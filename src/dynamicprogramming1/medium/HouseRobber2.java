package dynamicprogramming1.medium;

/**
 * Problem: 213. House Robber II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        int[] dp2 = new int[nums.length + 1];
        dp2[0] = 0;
        dp2[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
            dp2[i] = Math.max(nums[i - 1] + dp2[i - 2], dp2[i - 1]);
        }

        return Math.max(dp[nums.length - 1], dp2[nums.length]);
    }
}
