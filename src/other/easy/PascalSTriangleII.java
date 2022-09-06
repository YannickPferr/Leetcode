package other.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 119. Pascal's Triangle II
 * Difficulty: Easy
 * Link: https://leetcode.com/problemspascals-triangle-ii
 */
public class PascalSTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(1));
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> prev = l.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < prev.size(); j++)
                curr.add(prev.get(j - 1) + prev.get(j));
            curr.add(1);
            l.add(curr);
        }
        return l.get(rowIndex);
    }
}