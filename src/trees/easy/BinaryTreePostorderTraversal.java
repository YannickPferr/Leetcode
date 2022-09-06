package trees.easy;

import utils.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: 145. Binary Tree Postorder Traversal
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsbinary-tree-postorder-traversal
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
public class BinaryTreePostorderTraversal {
    List<Integer> l = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorderIt(root);
        return l;
    }

    public void postorderRec(TreeNode root) {
        if (root == null)
            return;

        postorderRec(root.left);
        postorderRec(root.right);
        l.add(root.val);
    }

    public void postorderIt(TreeNode root) {
        if (root == null)
            return;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                if (node.left != null)
                    node = node.left;
                else
                    node = node.right;
            }

            TreeNode temp = stack.pop();
            l.add(temp.val);
            if (!stack.isEmpty() && stack.peek().left == temp)
                node = stack.peek().right;
        }
    }
}