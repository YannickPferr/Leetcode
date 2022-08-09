package other.easy;

import java.util.Arrays;

/**
 * Problem: 1984. Minimum Difference Between Highest and Lowest of K Scores
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsminimum-difference-between-highest-and-lowest-of-k-scores
 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[start]);
            start++;
        }
        return min;
    }
}