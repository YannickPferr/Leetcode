package dynamicprogramming1.easy;

/**
 * Problem: 746. Min Cost Climbing Stairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/min-cost-climbing-stairs
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length + 1; i++) {
            int c = i < cost.length ? cost[i] : 0;
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + c;
        }

        return dp[cost.length];
    }
}