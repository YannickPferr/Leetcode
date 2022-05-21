package dynamicprogramming1.medium;

/**
 * Problem: 198. House Robber
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++)
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);

        return dp[nums.length];
    }
}
