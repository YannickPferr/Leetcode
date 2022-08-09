package other.medium;

/**
 * Problem: 59. Spiral Matrix II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsspiral-matrix-ii
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int right = n - 1;
        int left = 0;
        int down = n - 1;
        int up = 0;
        int[][] mat = new int[n][n];
        int num = 1;
        while (num <= n * n) {
            for (int j = left; j <= right; j++)
                mat[up][j] = num++;
            up++;

            for (int i = up; i <= down; i++)
                mat[i][right] = num++;
            right--;

            for (int j = right; j >= left; j--)
                mat[down][j] = num++;
            down--;

            for (int i = down; i >= up; i--)
                mat[i][left] = num++;
            left++;
        }
        return mat;
    }
}