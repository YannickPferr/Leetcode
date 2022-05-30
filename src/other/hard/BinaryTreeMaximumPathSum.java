package other.hard;

/**
 * Problem: 124. Binary Tree Maximum Path Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problemsbinary-tree-maximum-path-sum
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
public class BinaryTreeMaximumPathSum {
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath = root.val;
        return Math.max(max(root), maxPath);
    }

    public int max(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(0, max(node.left));
        int right = Math.max(0, max(node.right));
        maxPath = Math.max(maxPath, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}