package other.medium;

/**
 * Problem: 576. Out of Boundary Paths
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsout-of-boundary-paths
 */
public class OutOfBoundaryPaths {
    Integer[][][] cache;
    int mod = (int) (Math.pow(10, 9)) + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new Integer[m][n][maxMove + 1];
        return rec(m, n, startRow, startColumn, maxMove, 0);
    }

    public int rec(int m, int n, int x, int y, int maxMove, int currMoves) {
        if (x >= m || y >= n || x < 0 || y < 0)
            return 1;
        if (currMoves >= maxMove)
            return 0;
        if (cache[x][y][currMoves] != null)
            return cache[x][y][currMoves];

        long down = rec(m, n, x + 1, y, maxMove, currMoves + 1) % mod;
        long up = rec(m, n, x - 1, y, maxMove, currMoves + 1) % mod;
        long left = rec(m, n, x, y - 1, maxMove, currMoves + 1) % mod;
        long right = rec(m, n, x, y + 1, maxMove, currMoves + 1) % mod;
        long sum = (down + up + right + left) % mod;
        return cache[x][y][currMoves] = (int) sum;
    }
}