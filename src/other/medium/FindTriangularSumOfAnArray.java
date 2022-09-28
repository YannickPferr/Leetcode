package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2221. Find Triangular Sum of an Array
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsfind-triangular-sum-of-an-array
    */
    public class FindTriangularSumOfAnArray {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++)
            for(int j = 1; j < nums.length - i; j++)
                nums[j - 1] = (nums[j - 1] + nums[j]) % 10;
        return nums[0];
    }
}
    
