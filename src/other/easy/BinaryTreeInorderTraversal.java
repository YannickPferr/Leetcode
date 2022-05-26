package other.easy;
/**
 * Problem: 94. Binary Tree Inorder Traversal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal
 */

import java.util.ArrayList;
import java.util.List;

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
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        return l;
    }

    public void dfs(TreeNode root, List<Integer> l) {
        if (root == null)
            return;

        dfs(root.left, l);
        l.add(root.val);
        dfs(root.right, l);
    }
}