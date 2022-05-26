package trees.easy;
/**
 * Problem: 226. Invert Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/invert-binary-tree
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
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    public TreeNode invert(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = invert(root.right);
        root.right = invert(temp);
        return root;
    }
}