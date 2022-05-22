package trees.easy;

import trees.TreeNode;

/**
 * Problem: 226. Invert Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/invert-binary-tree/
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
