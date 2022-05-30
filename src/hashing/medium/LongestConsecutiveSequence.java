package hashing.medium;

import java.util.HashSet;

/**
 * Problem: 128. Longest Consecutive Sequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslongest-consecutive-sequence
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums)
            hs.add(num);

        int max = 0;
        for (int i : hs) {
            if (hs.contains(i + 1))
                continue;

            int curr = getSeq(hs, i - 1) + 1;
            max = Math.max(max, curr);
        }

        return max;
    }

    public int getSeq(HashSet<Integer> hs, int i) {
        if (!hs.contains(i))
            return 0;

        return getSeq(hs, i - 1) + 1;
    }
}