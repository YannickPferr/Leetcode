package other.medium;

/**
 * Problem: 63. Unique Paths II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsunique-paths-ii
 */
public class UniquePathsII {
    Integer[][] cache;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        cache = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return rec(obstacleGrid, 0, 0);
    }

    public int rec(int[][] obstacleGrid, int i, int j) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length)
            return 0;
        if (obstacleGrid[i][j] == 1)
            return 0;
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1)
            return 1;
        if (cache[i][j] != null)
            return cache[i][j];

        int a = rec(obstacleGrid, i + 1, j);
        int b = rec(obstacleGrid, i, j + 1);
        cache[i][j] = a + b;
        return cache[i][j];
    }
}