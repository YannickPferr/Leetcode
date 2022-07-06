package other.medium;

/**
 * Problem: 34. Find First and Last Position of Element in Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-first-and-last-position-of-element-in-sorted-array
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target)
                return findInterval(nums, m);
            else if (nums[m] > target)
                r = m - 1;
            else
                l = m + 1;
        }
        return new int[]{-1, -1};
    }

    public int[] findInterval(int[] nums, int m) {
        int target = nums[m];
        int l = m;
        int r = m;
        while (l - 1 >= 0 && nums[l - 1] == target)
            l--;
        while (r + 1 < nums.length && nums[r + 1] == target)
            r++;
        return new int[]{l, r};
    }
}