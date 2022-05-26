package other.easy;

/**
 * Problem: 26. Remove Duplicates from Sorted Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[prev]) {
                prev++;
                nums[prev] = nums[i];
            }
        }

        return prev + 1;
    }
}