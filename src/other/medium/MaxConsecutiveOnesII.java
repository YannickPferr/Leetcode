package other.medium;

/**
 * Problem: 487. Max Consecutive Ones II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmax-consecutive-ones-ii
 */
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int start = 0;
        int lastZero = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                start = lastZero + 1;
                lastZero = i;
            }
            max = Math.max(max, i + 1 - start);
        }

        return max;
    }
}