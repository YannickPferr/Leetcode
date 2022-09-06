package other.easy;

/**
 * Problem: 1480. Running Sum of 1d Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsrunning-sum-of-1d-array
 */
public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            runningSum[i] = nums[i] + runningSum[i - 1];
        return runningSum;
    }
}