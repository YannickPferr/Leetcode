package other.easy;

/**
 * Problem: 1022. Sum of Root To Leaf Binary Numbers
 * Difficulty: Easy
 * Link: https://leetcode.com/problemssum-of-root-to-leaf-binary-numbers
 */
public class SumOfRootToLeafBinaryNumbers {
    int countZeros = 0;

    public int uniquePathsIII(int[][] grid) {
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    countZeros++;
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
            }
        return dfs(grid, startI, startJ, 0);
    }

    public int dfs(int[][] grid, int i, int j, int currZeros) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        if (grid[i][j] == -1)
            return 0;
        if (grid[i][j] == 2 && (currZeros - 1) == countZeros)
            return 1;
        if (grid[i][j] == 2)
            return 0;

        grid[i][j] = -1;
        int down = dfs(grid, i + 1, j, currZeros + 1);
        int right = dfs(grid, i, j + 1, currZeros + 1);
        int up = dfs(grid, i - 1, j, currZeros + 1);
        int left = dfs(grid, i, j - 1, currZeros + 1);
        grid[i][j] = 0;
        return down + right + up + left;
    }
}