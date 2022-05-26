package graphs.medium;

/**
 * Problem: 200. Number of Islands
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-islands
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return;
        if (grid[i][j] == '0' || grid[i][j] == '2')
            return;

        grid[i][j] = '2';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}