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
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[l] <= nums[mid] && nums[mid] <= nums[r]) {
                if (nums[mid] > target)
                    r = mid - 1;
                else
                    l = mid + 1;
            } else if (nums[mid] <= nums[r] && nums[r] <= nums[l]) {
                if (nums[mid] > target)
                    r = mid - 1;
                else if (nums[r] < target)
                    r = mid - 1;
                else
                    l = mid + 1;
            } else if (nums[r] <= nums[l] && nums[l] <= nums[mid]) {
                if (nums[mid] < target)
                    l = mid + 1;
                else if (nums[l] > target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}


