package other.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 1260. Shift 2D Grid
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsshift-2d-grid
 */
public class Shift2dGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int shifts = k % (grid.length * grid[0].length);
        for (int i = 0; i < shifts; i++)
            grid = shiftGrid(grid);

        return toList(grid);
    }

    public int[][] shiftGrid(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid[0].length];
        newGrid[0][0] = grid[grid.length - 1][grid[0].length - 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                newGrid[i][j + 1] = grid[i][j];
            }
            if (i < grid.length - 1)
                newGrid[i + 1][0] = grid[i][grid[i].length - 1];
        }
        return newGrid;
    }

    public List<List<Integer>> toList(int[][] grid) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> l2 = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++)
                l2.add(grid[i][j]);
            l.add(l2);
        }
        return l;
    }
}