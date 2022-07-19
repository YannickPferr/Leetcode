package other.easy;

/**
 * Problem: 977. Squares of a Sorted Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problemssquares-of-a-sorted-array
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] newNums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[l] * nums[l] >= nums[r] * nums[r]) {
                newNums[i] = nums[l] * nums[l];
                l++;
            } else {
                newNums[i] = nums[r] * nums[r];
                r--;
            }
        }
        return newNums;
    }
}