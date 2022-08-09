package other.easy;

/**
 * Problem: 643. Maximum Average Subarray I
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmaximum-average-subarray-i
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];

        int max = sum;
        int start = 0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[start++];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}