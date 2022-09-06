package other.easy;

import utils.trees.TreeNode;

/**
 * Problem: 832. Flipping an Image
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsflipping-an-image
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
public class FlippingAnImage {
    public TreeNode pruneTree(TreeNode root) {
        boolean parent = dfs(root);
        if (!parent)
            return null;
        return root;
    }

    public boolean dfs(TreeNode node) {
        if (node == null)
            return false;

        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        if (!left)
            node.left = null;
        if (!right)
            node.right = null;
        return node.val == 1 || left || right;
    }
}