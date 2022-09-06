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
        int currStart = 0;
        int currEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            currEnd = Math.max(currEnd, s.lastIndexOf(s.charAt(i)));
            if (currEnd == i) {
                l.add(currEnd + 1 - currStart);
                currStart = currEnd + 1;
            }
        }
        return l;
    }
}