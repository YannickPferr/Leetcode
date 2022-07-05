package dynamicprogramming1.medium;

/**
 * Problem: 300. Longest Increasing Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslongest-increasing-subsequence
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        int globalMax = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j])
                    max = Math.max(max, 1 + dp[j]);
            }
            globalMax = Math.max(globalMax, max);
            dp[i] = max;
        }
        return globalMax;
    }
}