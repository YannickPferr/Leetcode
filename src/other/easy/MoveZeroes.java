package other.easy;

/**
 * Problem: 283. Move Zeroes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/move-zeroes
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 1;
        while (l < nums.length - 1 && r < nums.length) {
            if (nums[l] != 0) {
                l++;
                r++;
            } else {
                if (nums[r] == 0)
                    r++;
                else
                    swap(nums, l, r);
            }
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
