package other.medium;

/**
 * Problem: 1493. Longest Subarray of 1's After Deleting One Element
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslongest-subarray-of-1s-after-deleting-one-element
 */
public class LongestSubarrayOf1SAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int longest = 0;
        int lastZero = -1;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (lastZero != -1)
                    start = lastZero + 1;
                lastZero = i;
            }

            longest = Math.max(i - start, longest);
        }

        return longest;
    }
}