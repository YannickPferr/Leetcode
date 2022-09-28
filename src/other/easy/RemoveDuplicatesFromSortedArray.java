package other.easy;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

/**
 * Problem: 26. Remove Duplicates from Sorted Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsremove-duplicates-from-sorted-array
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