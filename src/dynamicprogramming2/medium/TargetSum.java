package dynamicprogramming2.medium;

import java.util.HashMap;

/**
 * Problem: 494. Target Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problemstarget-sum
 */
public class TargetSum {
    HashMap<String, Integer> cache;

    public int findTargetSumWays(int[] nums, int target) {
        cache = new HashMap<>();
        return rec(nums, target, 0);
    }

    public int rec(int[] nums, int target, int pos) {
        if (target == 0 && pos == nums.length)
            return 1;
        if (pos >= nums.length)
            return 0;
        if (cache.containsKey("T" + target + "P" + pos))
            return cache.get("T" + target + "P" + pos);


        int a = rec(nums, target - nums[pos], pos + 1);
        int b = rec(nums, target + nums[pos], pos + 1);
        cache.put("T" + target + "P" + pos, a + b);
        return a + b;
    }
}