package toptal;

public class Problem2 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{5, 4, 3, 2, 6}));
        System.out.println(solution(new int[]{3,7,4,5}));
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        if(isAlternate(A)) return 0;
        int[] differences = new int[A.length];
        for(int i = 0;i<A.length-1;i++) {
            differences[i] = A[i+1] - A[i];
        }
        for(int i = 0;i<differences.length-1;i++) {
            differences[i] = A[i+1] - A[i];
        }
        return 1;
    }
    public static boolean  isAlternate(int[]A){
        for(int i = 0;i<A.length-2;i++){
            if(!isNext3AlternateSequence(A, i))return false;
        }
        return true;
    }

    private static boolean isNext3AlternateSequence(int[] A, int i) {
        return (A[i]<A[i+1] && A[i+1] > A[i+2] ) || (A[i]>A[i+1] &&A[i+1] <A[i+2]);
    }
}
  