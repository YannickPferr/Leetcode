package other.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 163. Missing Ranges
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmissing-ranges
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> l = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            int curr = i == nums.length ? upper + 1 : nums[i];
            int prev = i == 0 ? lower - 1 : nums[i - 1];
            int diff = curr - prev;
            if (diff > 1) {
                int start = prev + 1;
                int end = curr - 1;
                if (start == end)
                    l.add(String.valueOf(start));
                else
                    l.add(start + "->" + end);
            }
        }
        return l;
    }
}