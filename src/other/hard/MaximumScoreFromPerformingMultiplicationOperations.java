package other.hard;

/**
 * Problem: 1770. Maximum Score from Performing Multiplication Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problemsmaximum-score-from-performing-multiplication-operations
 */
public class MaximumScoreFromPerformingMultiplicationOperations {
    Integer[][] cache;

    public int maximumScore(int[] nums, int[] multipliers) {
        cache = new Integer[multipliers.length][multipliers.length];
        return rec(nums, 0, nums.length - 1, multipliers, 0);
    }

    public int rec(int[] nums, int start, int end, int[] multipliers, int pos) {
        if (pos == multipliers.length)
            return 0;
        if (cache[start][pos] != null)
            return cache[start][pos];

        cache[start][pos] = Math.max(rec(nums, start + 1, end, multipliers, pos + 1) + multipliers[pos] * nums[start], rec(nums, start, end - 1, multipliers, pos + 1) + multipliers[pos] * nums[end]);
        return cache[start][pos];
    }
}