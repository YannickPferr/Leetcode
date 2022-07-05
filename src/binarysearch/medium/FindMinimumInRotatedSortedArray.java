package binarysearch.medium;

/**
 * Problem: 153. Find Minimum in Rotated Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-minimum-in-rotated-sorted-array
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[l] <= nums[m]) {
                if (nums[m] <= nums[r])
                    return nums[l];
                else
                    l = m + 1;
            } else
                r = m;
        }
        return -1;
    }
}