package trees.easy;

import utils.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: 144. Binary Tree Preorder Traversal
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsbinary-tree-preorder-traversal
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
public class BinaryTreePreorderTraversal {
    List<Integer> l = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        //preorderRec(root);
        preorderIt(root);
        return l;
    }

    public void preorderRec(TreeNode root) {
        if (root == null)
            return;

        l.add(root.val);
        preorderRec(root.left);
        preorderRec(root.right);
    }

    public void preorderIt(TreeNode root) {
        if (root == null)
            return;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeLast();
            l.add(node.val);
            if (node.right != null)
                stack.addLast(node.right);
            if (node.left != null)
                stack.addLast(node.left);
        }
    }
}