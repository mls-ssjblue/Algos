package toptal;

public class Problem3 {
    static int max = 0;
    static String current = "";
    public static void main(String[] args) {

//        System.out.println(solution(new int[]{5, 4, 3, 2, 6}));
    }
    public static int solution(int[][] Board) {
        // write your code in Java SE 8
        helper(Board, 0,0);
        return max;
    }
    private static String helper(int[][] matrix, int r, int c){

        if(r==matrix.length-1 && c==matrix[0].length-1) return matrix[r][c] + "";
        if(r==matrix.length-1 ) current += Math.max(Integer.parseInt(helper(matrix,r,c+1)),Integer.parseInt(helper(matrix,r-1,c)));
        if(r==0 ) current += Math.max(Integer.parseInt(helper(matrix,r,c+1)),Integer.parseInt(helper(matrix,r+1,c)));
        if(c==matrix[0].length-1 ) current += Math.max(Integer.parseInt(helper(matrix,r-1,c)),Integer.parseInt(helper(matrix,r+1,c)));

        current += matrix[r][c] + findMax(helper(matrix,r,c+1), helper(matrix,r+1,c),helper(matrix,r-1,c));
        if(Integer.parseInt(current) > max)max = Integer.parseInt(current);
        return current;
    }

    private static String findMax(String a, String b, String c){
        int max = Math.max(Integer.parseInt(a), Math.max(Integer.parseInt(b), Integer.parseInt(c)));
        return max+"";
    }
    private static double findMaxNeighbour(int[][] matrix, int r, int c) {
        if(r==matrix.length-1 ) return Math.max(matrix[r][c+1], matrix[r-1][c]);
        if(r==0 ) return Math.max(matrix[r][c+1], matrix[r+1][c]);
        if(r==matrix[0].length-1 ) return Math.max(matrix[r-1][c], matrix[r+1][c]);
        return Math.max(Math.max(matrix[r][c+1], matrix[r-1][c]), matrix[r+1][c]);
    }
}
  