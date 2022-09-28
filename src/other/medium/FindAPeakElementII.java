package other.medium;

/**
 * Problem: 1901. Find a Peak Element II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-a-peak-element-ii
 */
public class FindAPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int l = 0;
        int r = mat[0].length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int maxRow = 0;
            for (int i = 1; i < mat.length; i++)
                maxRow = mat[i][m] > mat[maxRow][m] ? i : maxRow;

            int left = m - 1 < 0 ? -1 : mat[maxRow][m - 1];
            int right = m + 1 >= mat[0].length ? -1 : mat[maxRow][m + 1];
            if (mat[maxRow][m] > left && mat[maxRow][m] > right)
                return new int[]{maxRow, m};
            else if (mat[maxRow][m] > left)
                l = m + 1;
            else
                r = m - 1;
        }
        return new int[]{-1, -1};
    }
}
