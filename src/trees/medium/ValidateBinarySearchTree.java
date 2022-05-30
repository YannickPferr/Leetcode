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
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return rec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean rec(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        if (node.val >= max || node.val <= min)
            return false;

        return rec(node.left, min, node.val) && rec(node.right, node.val, max);
    }
}