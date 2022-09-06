package other.easy;

/**
 * Problem: 1413. Minimum Value to Get Positive Step by Step Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsminimum-value-to-get-positive-step-by-step-sum
 */
public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int running = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            running += nums[i];
            min = Math.min(running, min);
        }

        if (min < 0)
            return min * -1 + 1;
        return 1;
    }
}