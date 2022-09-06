package other.medium;

import java.util.ArrayList;

/**
 * Problem: 1762. Buildings With an Ocean View
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsbuildings-with-an-ocean-view
 */
public class BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> l = new ArrayList<>();
        int max = heights[heights.length - 1];
        l.add(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > max) {
                l.add(i);
                max = heights[i];
            }
        }

        int[] out = new int[l.size()];
        int j = 0;
        for (int i = l.size() - 1; i >= 0; i--)
            out[i] = l.get(j++);
        return out;
    }
}