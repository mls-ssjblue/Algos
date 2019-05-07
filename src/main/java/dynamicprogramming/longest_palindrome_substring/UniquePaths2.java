package dynamicprogramming.longest_palindrome_substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniquePaths2 {

    @Test
    public void test() {
        int[][] maze = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        Assertions.assertEquals(2, uniquePathsWithObstacles(maze));
    }

    public int uniquePathsWithObstacles(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] dp = new int[m][n];
        if (m == 1) {
            for (int i = 0; i < n; i++) if (maze[0][i] == 1) return 0;
            return 1;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) if (maze[i][0] == 1) return 0;
            return 1;
        }

        dp[m - 1][n - 2] = maze[m - 1][n - 2] == 0 ? 1 : 0;
        dp[m - 2][n - 1] = maze[m - 2][n - 1] == 0 ? 1 : 0;

        lastRowBlocks(maze, m, n, dp);
        lastColumnBlocks(maze, m, n, dp);


        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = maze[i][j] == 0 ? dp[i + 1][j] + dp[i][j + 1] : 0 ;
            }
        }
        return dp[0][0];
    }

    private void lastColumnBlocks(int[][] maze, int m, int n, int[][] dp) {
        int blocked = 0;

        for (int i = m-1; i >=0; i--) {
            if (maze[i][n - 1] == 1) {
                blocked = 1;
            }
            if(blocked == 1) dp[i][n-1] = 0;
            else dp[i][n-1] = 1;
        }


    }

    private void lastRowBlocks(int[][] maze, int m, int n, int[][] dp) {
        int blocked = 0;

        for (int i = n-1; i >=0; i--) {
            if (maze[m-1][i] == 1) {
                blocked = 1;
            }
            if(blocked == 1) dp[m-1][i] = 0;
            else dp[m-1][i] = 1;
        }
    }
}
