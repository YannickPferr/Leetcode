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
        return dfs(root, -10000);
    }

    public int dfs(TreeNode node, int max) {
        if (node == null)
            return 0;
        int count = node.val >= max ? 1 : 0;
        return count + dfs(node.left, Math.max(max, node.val)) + dfs(node.right, Math.max(max, node.val));
    }
}