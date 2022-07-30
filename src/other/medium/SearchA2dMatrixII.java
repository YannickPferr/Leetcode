package other.medium;

/**
 * Problem: 240. Search a 2D Matrix II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssearch-a-2d-matrix-ii
 */
public class SearchA2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target)
                j--;
            else if (matrix[i][j] < target)
                i++;
            else
                return true;
        }
        return false;
    }
}