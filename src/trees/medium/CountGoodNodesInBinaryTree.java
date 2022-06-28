package trees.medium;

import utils.trees.TreeNode;
/**
 * Problem: 1448. Count Good Nodes in Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscount-good-nodes-in-binary-tree
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
public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        return rec(root, Integer.MIN_VALUE);
    }

    public int rec(TreeNode root, int currMax) {
        if (root == null)
            return 0;

        int count = 0;
        if (root.val >= currMax) {
            count++;
            currMax = root.val;
        }

        return count + rec(root.left, currMax) + rec(root.right, currMax);
    }
}