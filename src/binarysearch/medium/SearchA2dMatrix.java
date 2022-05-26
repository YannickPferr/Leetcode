package binarysearch.medium;

/**
 * Problem: 74. Search a 2D Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/search-a-2d-matrix
 */
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int i = m / matrix[0].length;
            int j = m % matrix[0].length;

            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                l = m + 1;
            else
                r = m - 1;
        }

        return false;
    }
}