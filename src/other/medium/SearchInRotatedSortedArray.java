package other.medium;

/**
 * Problem: 33. Search in Rotated Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssearch-in-rotated-sorted-array
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[m] > target) {
                if (nums[l] <= nums[m] && nums[m] <= nums[r])
                    r = m - 1;
                else if (nums[l] >= nums[m] && nums[m] <= nums[r])
                    r = m - 1;
                else if (nums[l] <= nums[m] && nums[m] >= nums[r]) {
                    if (nums[l] <= target)
                        r = m - 1;
                    else
                        l = m + 1;
                }
            } else {
                if (nums[l] <= nums[m] && nums[m] <= nums[r])
                    l = m + 1;
                else if (nums[l] >= nums[m] && nums[m] <= nums[r]) {
                    if (nums[l] > target)
                        l = m + 1;
                    else
                        r = m - 1;
                } else if (nums[l] <= nums[m] && nums[m] >= nums[r])
                    l = m + 1;
            }
        }
        return -1;
    }
}