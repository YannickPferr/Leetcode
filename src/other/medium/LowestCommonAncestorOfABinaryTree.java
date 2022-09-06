package other.medium;

import utils.trees.TreeNode;

/**
 * Problem: 236. Lowest Common Ancestor of a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslowest-common-ancestor-of-a-binary-tree
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    public TreeNode find(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        if (node == p || node == q)
            return node;

        TreeNode left = find(node.left, p, q);
        TreeNode right = find(node.right, p, q);
        if (left != null && right != null)
            return node;
        return left != null ? left : right;
    }
}