package other.easy;

/**
 * Problem: 1351. Count Negative Numbers in a Sorted Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problemscount-negative-numbers-in-a-sorted-matrix
 */
public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int numNegs = 0;
        int i = grid.length - 1;
        while (i >= 0) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0)
                    numNegs++;
                else
                    break;
            }
            i--;
        }
        return numNegs;
    }
}