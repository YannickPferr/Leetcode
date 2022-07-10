package dynamicprogramming1.medium;

/**
 * Problem: 416. Partition Equal Subset Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspartition-equal-subset-sum
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;

        return backtracking(nums, 0, sum / 2, new Boolean[nums.length][sum / 2 + 1]);
    }

    public boolean backtracking(int[] nums, int i, int target, Boolean[][] dp) {
        if (target < 0)
            return false;
        if (i >= nums.length)
            return false;
        if (target == 0)
            return true;
        if (dp[i][target] != null)
            return dp[i][target];

        dp[i][target] = backtracking(nums, i + 1, target - nums[i], dp) || backtracking(nums, i + 1, target, dp);
        return dp[i][target];
    }
}