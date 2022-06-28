package other.easy;

/**
 * Problem: 27. Remove Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsremove-element
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] != val) {
                l++;
                continue;
            }
            if (nums[r] == val) {
                r--;
                continue;
            }

            if (nums[l] == val && nums[r] != val) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = nums[l];
                l++;
                r--;
            }
        }

        return l;
    }
}