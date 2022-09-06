package other.medium;

import java.util.Arrays;

/**
 * Problem: 63. Unique Paths II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsunique-paths-ii
 */
public class UniquePathsII {
    int[][] cache;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] c : cache)
            Arrays.fill(c, -1);
        return dfs(obstacleGrid, 0, 0);
    }

    public int dfs(int[][] grid, int i, int j) {
        if (isOutOfBounds(grid, i, j))
            return 0;
        if (grid[i][j] == 1)
            return 0;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return 1;
        if (cache[i][j] != -1)
            return cache[i][j];

        cache[i][j] = dfs(grid, i + 1, j) + dfs(grid, i, j + 1);
        return cache[i][j];
    }

    public boolean isOutOfBounds(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length)
            return true;
        if (i < 0 || j < 0)
            return true;
        return false;
    }
}

//7mins