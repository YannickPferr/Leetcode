package greedy.easy;

/**
 * Problem: 53. Maximum Subarray
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int localMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            localMax = Math.max(localMax + num, num);
            globalMax = Math.max(localMax, globalMax);
        }

        //needed when all numbers are negative
        localMax = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            localMax = Math.max(localMax + num, num);
            globalMax = Math.max(localMax, globalMax);
        }

        return globalMax;
    }
}
