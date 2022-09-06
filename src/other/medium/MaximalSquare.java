package other.medium;

/**
 * Problem: 221. Maximal Square
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximal-square
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = (matrix[i][0] == '1' ? 1 : 0);
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = (matrix[0][j] == '1' ? 1 : 0);
            max = Math.max(max, dp[0][j]);
        }

        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == '0')
                    continue;

                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }

        return max * max;
    }
}