//package ctci.dp;
//
//import com.sun.tools.javac.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NQueens {
//
//    private  static List<List<String>> solution = new ArrayList<>();
//    public static void main(String[] args) {
//
//        List<List<String>> solution  = nQueens(4);
//    }
//
//    private static List<List<String>> nQueens(int N) {
//
//        // n x n board
//        int[][] board = new int[N][N];
//        List<String > queens = new ArrayList<>();
//        nQueensHelper(N, board, queens);
//        return solution;
//    }
//
//    private static List<List<String>> nQueensHelper(int N, int[][] board, List<String> queens){
//
//        if(queens.size() == N) {
//            List<String> queenString = new ArrayList<>();
//            queens.forEach(queen -> {
//                String s = StringUtils.repeat("x", n);
//                queenString.add()
//                    }
//                    );
//
//        }
//
//    }
//}
