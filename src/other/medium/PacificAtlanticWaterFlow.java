package other.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 417. Pacific Atlantic Water Flow
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspacific-atlantic-water-flow
 */
public class PacificAtlanticWaterFlow {

    boolean[][] pac;
    boolean[][] atl;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> reaches = new ArrayList<>();
        pac = new boolean[heights.length][heights[0].length];
        atl = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            canReach(heights, i, 0, Integer.MIN_VALUE, pac);
            canReach(heights, i, heights[0].length - 1, Integer.MIN_VALUE, atl);
        }

        for (int j = 0; j < heights[0].length; j++) {
            canReach(heights, 0, j, Integer.MIN_VALUE, pac);
            canReach(heights, heights.length - 1, j, Integer.MIN_VALUE, atl);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pac[i][j] && atl[i][j])
                    reaches.add(Arrays.asList(i, j));
            }
        }
        return reaches;
    }

    public void canReach(int[][] heights, int i, int j, int prev, boolean[][] visited) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length)
            return;
        if (visited[i][j] || heights[i][j] < prev)
            return;

        visited[i][j] = true;
        canReach(heights, i + 1, j, heights[i][j], visited);
        canReach(heights, i - 1, j, heights[i][j], visited);
        canReach(heights, i, j + 1, heights[i][j], visited);
        canReach(heights, i, j - 1, heights[i][j], visited);
    }
}