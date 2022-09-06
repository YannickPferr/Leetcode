package graphs.medium;

/**
 * Problem: 200. Number of Islands
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnumber-of-islands
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1' && dfs(grid, i, j))
                    numIslands++;
        return numIslands;
    }

    public boolean dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0)
            return false;
        if (grid[i][j] != '1')
            return false;

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return true;
    }
}