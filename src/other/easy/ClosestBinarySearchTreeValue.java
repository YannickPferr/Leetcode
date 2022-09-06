package other.easy;

import utils.trees.TreeNode;

/**
 * Problem: 270. Closest Binary Search Tree Value
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsclosest-binary-search-tree-value
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
public class ClosestBinarySearchTreeValue {
    double min = Double.MAX_VALUE;
    int minNode = -1;

    public int closestValue(TreeNode root, double target) {
        find(root, target);
        return minNode;
    }

    public void find(TreeNode node, double target) {
        if (node == null)
            return;

        if (Math.abs(node.val - target) < min) {
            min = Math.abs(node.val - target);
            minNode = node.val;
        }
        find(node.left, target);
        find(node.right, target);
    }
}