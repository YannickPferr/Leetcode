package other.easy;

import utils.trees.TreeNode;

/**
 * Problem: 2331. Evaluate Boolean Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsevaluate-boolean-binary-tree
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
public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return root.val == 1;

        if (root.val == 2)
            return evaluateTree(root.left) || evaluateTree(root.right);
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}