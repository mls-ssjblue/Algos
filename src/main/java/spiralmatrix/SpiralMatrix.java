import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[3][4];
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = count;
                count++;
            }
        }

        List<Integer> spiral = spiralOrder(matrix);
        System.out.println(spiral.toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spiral = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 1;
        int levels = n;
        int max = Math.max(m, n);
        while (l <= levels) {

            for (int k = l-1; k <= n - l - 1; k++) {
                spiral.add(Integer.valueOf(matrix[l - 1][k]));
            }
            for (int k = l-1; k <= m - l - 1; k++) {
                spiral.add(Integer.valueOf(matrix[k][n - l]));

            }
            for (int k = l-1; k <= n - l - 1; k++) {
                spiral.add(Integer.valueOf(matrix[m - 1][n-l-k]));

            }
            for (int k =l-1; k <= m - l - 1; k++) {
                spiral.add(Integer.valueOf(matrix[m-l-k][l - 1]));

            }
            l++;
        }
        return spiral;
    }
}
