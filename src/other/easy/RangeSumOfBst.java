package other.easy;

import utils.trees.TreeNode;

/**
 * Problem: 938. Range Sum of BST
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsrange-sum-of-bst
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class RangeSumOfBst {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rec(root, low, high);
    }

    public int rec(TreeNode node, int low, int high) {
        if (node == null)
            return 0;

        int val = node.val;
        if (node.val < low || node.val > high)
            val = 0;

        return val + rec(node.left, low, high) + rec(node.right, low, high);
    }
}