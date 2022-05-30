package trees.easy;

import utils.trees.TreeNode;
/**
 * Problem: 543. Diameter of Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsdiameter-of-binary-tree
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
public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        max = Math.max(max, heightLeft + heightRight);

        return Math.max(heightLeft, heightRight) + 1;
    }
}