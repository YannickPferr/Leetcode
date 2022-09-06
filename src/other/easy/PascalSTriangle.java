package other.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 118. Pascal's Triangle
 * Difficulty: Easy
 * Link: https://leetcode.com/problemspascals-triangle
 */
public class PascalSTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = l.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < prev.size(); j++)
                row.add(prev.get(j - 1) + prev.get(j));
            row.add(1);
            l.add(row);
        }
        return l;
    }
}