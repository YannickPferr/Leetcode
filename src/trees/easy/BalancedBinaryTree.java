package trees.easy; /**
 * Problem: 110. Balanced Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsbalanced-binary-tree
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
public class BalancedBinaryTree {

    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        rec(root);
        return balanced;
    }

    public int rec(TreeNode root) {
        if (root == null)
            return 0;

        int heightLeft = rec(root.left);
        int heightRight = rec(root.right);
        boolean heightsDifferByMoreThan1 = Math.abs(heightLeft - heightRight) > 1;
        if (heightsDifferByMoreThan1)
            balanced = false;

        return Math.max(heightLeft, heightRight) + 1;
    }
}