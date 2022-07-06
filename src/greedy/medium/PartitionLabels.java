package greedy.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 763. Partition Labels
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspartition-labels
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> l = new ArrayList<>();
        int start = 0;
        int currEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            int lastIdx = s.lastIndexOf(s.charAt(i));
            currEnd = Math.max(currEnd, lastIdx);
            if (i == currEnd) {
                l.add(currEnd + 1 - start);
                start = currEnd + 1;
                currEnd = start;
            }
        }
        return l;
    }
}