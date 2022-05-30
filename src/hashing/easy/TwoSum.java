package hashing.easy;

import java.util.HashMap;

/**
 * Problem: 1. Two Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problemstwo-sum
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i]))
                return new int[]{hm.get(target - nums[i]), i};

            hm.put(nums[i], i);
        }

        return null;
    }
}