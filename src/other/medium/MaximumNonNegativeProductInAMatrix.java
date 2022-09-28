package other.medium;

/**
 * Problem: 1594. Maximum Non Negative Product in a Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximum-non-negative-product-in-a-matrix
 */
public class MaximumNonNegativeProductInAMatrix {
    public int maxProductPath(int[][] grid) {
        return (int) (rec(grid, 0, 0, 1) % (Math.pow(10, 9) + 7));
    }

    public long rec(int[][] grid, int x, int y, long currProd) {
        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0)
            return -1;
        if (grid[x][y] == 0)
            return 0;
        long prod = currProd * grid[x][y];
        if (x == grid.length - 1 && y == grid[0].length - 1)
            return prod > 0 ? prod : -1;

        long down = rec(grid, x + 1, y, prod);
        long right = rec(grid, x, y + 1, prod);
        return Math.max(down, right);
    }
}