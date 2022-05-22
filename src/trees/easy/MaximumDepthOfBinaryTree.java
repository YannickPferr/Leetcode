package trees.easy;

import trees.TreeNode;

/**
 * Problem: 104. Maximum Depth of Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
