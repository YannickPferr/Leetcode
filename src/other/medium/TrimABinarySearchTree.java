package other.medium;

/**
 * Problem: 669. Trim a Binary Search Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problemstrim-a-binary-search-tree
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
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    public TreeNode dfs(TreeNode node, int low, int high) {
        if (node == null)
            return null;

        node.left = dfs(node.left, low, high);
        node.right = dfs(node.right, low, high);
        if (node.val < low)
            return node.right;
        else if (node.val > high)
            return node.left;

        return node;
    }
}