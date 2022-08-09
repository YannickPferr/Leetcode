package math.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 54. Spiral Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsspiral-matrix
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int right = matrix[0].length - 1;
        int left = 0;
        int down = matrix.length - 1;
        int up = 0;
        List<Integer> l = new ArrayList<>();
        while (l.size() < matrix.length * matrix[0].length) {
            for (int j = left; j <= right; j++)
                l.add(matrix[up][j]);
            up++;
            if (l.size() == matrix.length * matrix[0].length)
                return l;
            for (int i = up; i <= down; i++)
                l.add(matrix[i][right]);
            right--;
            if (l.size() == matrix.length * matrix[0].length)
                return l;
            for (int j = right; j >= left; j--)
                l.add(matrix[down][j]);
            down--;
            if (l.size() == matrix.length * matrix[0].length)
                return l;
            for (int i = down; i >= up; i--)
                l.add(matrix[i][left]);
            left++;
            if (l.size() == matrix.length * matrix[0].length)
                return l;
        }
        return l;
    }
}