package other.medium;

/**
 * Problem: 540. Single Element in a Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssingle-element-in-a-sorted-array
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid - 1 < 0 || nums[mid] != nums[mid - 1]) && (mid + 1 >= nums.length || nums[mid] != nums[mid + 1]))
                return nums[mid];
            else if ((mid - 1 >= 0 && nums[mid] == nums[mid - 1])) {
                if ((mid - 1 - l) % 2 == 0)
                    l = mid + 1;
                else
                    r = mid - 2;
            } else if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]) {
                if ((r - (mid + 1)) % 2 == 0)
                    r = mid - 1;
                else
                    l = mid + 2;
            }
        }
        return nums[l];
    }
}