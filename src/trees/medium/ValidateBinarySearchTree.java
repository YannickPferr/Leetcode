package trees.medium;

import utils.trees.TreeNode;

/**
 * Problem: 98. Validate Binary Search Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsvalidate-binary-search-tree
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
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValid(TreeNode node, long highest, long lowest) {
        if (node == null)
            return true;
        if (node.val >= highest || node.val <= lowest)
            return false;

        return isValid(node.left, node.val, lowest) && isValid(node.right, highest, node.val);
    }
}