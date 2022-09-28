package other.medium;

/**
 * Problem: 378. Kth Smallest Element in a Sorted Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problemskth-smallest-element-in-a-sorted-matrix
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int r = matrix[matrix.length - 1][matrix[0].length - 1];
        while (l < r) {
            int m = l + (r - l) / 2;
            int count = countSmallerOrEqual(matrix, m, k);
            if (count >= k)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public int countSmallerOrEqual(int[][] matrix, int el, int maxCount) {
        int count = 0;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0 && count <= maxCount) {
            if (matrix[i][j] <= el) {
                count += j + 1;
                i++;
            } else
                j--;
        }
        return count;
    }
}