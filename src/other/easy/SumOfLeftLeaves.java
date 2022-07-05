package other.easy;

/**
 * Problem: 404. Sum of Left Leaves
 * Difficulty: Easy
 * Link: https://leetcode.com/problemssum-of-left-leaves
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
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    public int sum(TreeNode node, boolean isLeft) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null && !isLeft)
            return 0;
        if (node.left == null && node.right == null && isLeft)
            return node.val;

        return sum(node.left, true) + sum(node.right, false);
    }
}