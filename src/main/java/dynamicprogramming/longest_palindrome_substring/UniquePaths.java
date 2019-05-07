package dynamicprogramming.longest_palindrome_substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniquePaths {

    @Test
    void test() {
        Assertions.assertEquals(28, uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        if(n==1 || m ==1) return 1;
        dp[m - 1][n - 2] = dp[m - 2][n - 1] = 1;
        for (int i = 0; i < n; i++) dp[m - 1][i] = 1;
        for (int i = 0; i < m; i++) dp[i][n - 1] = 1;

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
