package other.medium;

/**
 * Problem: 162. Find Peak Element
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-peak-element
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int right = i + 1 < nums.length ? nums[i + 1] : Integer.MIN_VALUE;
            int left = i - 1 >= 0 ? nums[i - 1] : Integer.MIN_VALUE;
            if (nums[i] == Math.max(Math.max(nums[i], right), left))
                return i;
        }
        return -1;
    }
}