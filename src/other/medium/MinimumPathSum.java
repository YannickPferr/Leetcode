package other.medium;

/**
 * Problem: 64. Minimum Path Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-path-sum
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        return bottomUp(grid);
    }

    Integer[][] cache;

    public int topDown(int[][] grid) {
        cache = new Integer[grid.length][grid[0].length];
        return rec(grid, 0, 0);
    }

    public int rec(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        if (i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;
        if (cache[i][j] != null)
            return cache[i][j];

        int a = rec(grid, i + 1, j);
        int b = rec(grid, i, j + 1);
        cache[i][j] = grid[i][j] + Math.min(a, b);
        return cache[i][j];
    }

    public int bottomUp(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp.length; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int j = 1; j < dp[0].length; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];

        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++)
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);

        return dp[dp.length - 1][dp[0].length - 1];
    }


}