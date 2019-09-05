package ctci.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotMaze {

    @Test
    public void test() {

        Assertions.assertEquals(2, numPaths3(2, 2));
        Assertions.assertEquals(3, numPaths3(2, 3));
    }

    private int numPaths3(int m, int n) {

        int[][] paths = new int[100][100];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 || j==0){ paths[i][j] = 1; continue;}
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[n-1][m-1];
    }

    private int numPaths2(int m, int n) {
        int[][] paths = new int[100][100];
        return numPaths2Helper(m, n, paths);
    }

    private int numPaths2Helper(int m, int n, int[][] paths) {
        if (paths[m - 1][n - 1] > 0) return paths[m - 1][n - 1];
        if (m == 1 || n == 1) return 1;
        paths[m - 1][n - 1] = numPaths2Helper(m - 1, n, paths) + numPaths2Helper(m, n - 1, paths);
        return paths[m - 1][n - 1];
    }

    private int numPaths1(int x, int y) {
        if (x == 1 || y == 1) return 1;
        return numPaths1(x - 1, y) + numPaths1(x, y - 1);
    }

}
