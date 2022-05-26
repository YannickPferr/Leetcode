package other.easy;
/**
 * Problem: 101. Symmetric Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/symmetric-tree
 */

import java.util.ArrayDeque;
import java.util.Deque;

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
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.right == null && root.left == null)
            return true;
        else if (root.right != null && root.left != null) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.addFirst(root.left);
            stack.addFirst(root.right);
            while (!stack.isEmpty()) {
                TreeNode r = stack.removeFirst();
                TreeNode l = stack.removeFirst();

                if (r.val != l.val)
                    return false;
                else if (l.left == null && r.right != null)
                    return false;
                else if (l.left != null && r.right == null)
                    return false;
                else if (l.right == null && r.left != null)
                    return false;
                else if (l.right != null && r.left == null)
                    return false;

                if (l.left != null && r.right != null) {
                    stack.addFirst(l.left);
                    stack.addFirst(r.right);
                }
                if (l.right != null && r.left != null) {
                    stack.addFirst(l.right);
                    stack.addFirst(r.left);
                }
            }
        } else
            return false;

        return true;
    }

    public boolean dfs(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;

        if (l != null && r != null) {
            return dfs(l.left, r.right) && dfs(l.right, r.left) && l.val == r.val;
        }

        return false;
    }
}