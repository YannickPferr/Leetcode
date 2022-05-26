package trees.easy;
/**
 * Problem: 104. Maximum Depth of Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree
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
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}