package other.medium;

/**
 * Problem: 162. Find Peak Element
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-peak-element
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long left = m - 1 < 0 ? Long.MIN_VALUE : nums[m - 1];
            long right = m + 1 >= nums.length ? Long.MIN_VALUE : nums[m + 1];
            if (nums[m] > left && nums[m] > right)
                return m;
            else if (nums[m] > left)
                l = m + 1;
            else
                r = m - 1;
        }
        return l;
    }
}