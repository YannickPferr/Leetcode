package other.medium;

/**
 * Problem: 1277. Count Square Submatrices with All Ones
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscount-square-submatrices-with-all-ones
 */
public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int count = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
            count += matrix[i][0];
        }

        for (int j = 1; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j];
            count += matrix[0][j];
        }

        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    count += dp[i][j];
                }
            }

        return count;
    }
}