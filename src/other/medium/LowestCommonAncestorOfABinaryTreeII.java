package other.medium;

import utils.trees.TreeNode;

/**
 * Problem: 1644. Lowest Common Ancestor of a Binary Tree II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslowest-common-ancestor-of-a-binary-tree-ii
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
public class LowestCommonAncestorOfABinaryTreeII {
    TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return node;
    }

    public boolean find(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;

        boolean curr = node == p || node == q;
        boolean left = find(node.left, p, q);
        boolean right = find(node.right, p, q);
        if (curr && (left || right) || (left && right))
            this.node = node;
        return curr || left || right;
    }
}