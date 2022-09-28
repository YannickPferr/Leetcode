package other.medium;

/**
 * Problem: 1004. Max Consecutive Ones III
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmax-consecutive-ones-iii
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int countZero = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i - start);
            if (nums[i] == 0) {
                countZero++;
                while (countZero > k)
                    countZero += (nums[start++] - 1);
            }
        }
        return Math.max(max, nums.length - start);
    }
}