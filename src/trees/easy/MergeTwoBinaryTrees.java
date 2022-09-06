package trees.easy;

import utils.trees.TreeNode;

/**
 * Problem: 617. Merge Two Binary Trees
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmerge-two-binary-trees
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
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return rec(root1, root2);
    }

    public TreeNode rec(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return null;
        if (node1 == null && node2 != null)
            return node2;
        if (node1 != null && node2 == null)
            return node1;

        TreeNode node = new TreeNode(node1.val + node2.val);
        node.left = rec(node1.left, node2.left);
        node.right = rec(node1.right, node2.right);
        return node;
    }
}