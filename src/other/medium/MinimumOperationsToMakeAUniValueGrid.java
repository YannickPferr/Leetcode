package other.medium;

import java.util.Arrays;

/**
 * Problem: 2033. Minimum Operations to Make a Uni-Value Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-operations-to-make-a-uni-value-grid
 */
public class MinimumOperationsToMakeAUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int n = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                arr[n++] = grid[i][j];

        Arrays.sort(arr);
        int median = arr[arr.length / 2];
        int sum = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if ((grid[i][j] - median) % x != 0)
                    return -1;
                sum += Math.abs((grid[i][j] - median) / x);
            }

        return sum;
    }
}
