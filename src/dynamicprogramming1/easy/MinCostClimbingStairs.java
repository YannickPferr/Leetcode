package dynamicprogramming1.easy;

/**
 * Problem: 746. Min Cost Climbing Stairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmin-cost-climbing-stairs
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = cost[0];
        int prev1 = cost[1];
        int curr = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            curr = Math.min(prev1, prev2) + (i >= cost.length ? 0 : cost[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}