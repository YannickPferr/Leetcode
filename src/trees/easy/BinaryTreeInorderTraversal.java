package trees.easy;

import utils.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Problem: 94. Binary Tree Inorder Traversal
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsbinary-tree-inorder-traversal
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
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        //dfs(root, l);
        it(root, l);
        return l;
    }

    public void dfs(TreeNode root, List<Integer> l) {
        if (root == null)
            return;

        dfs(root.left, l);
        l.add(root.val);
        dfs(root.right, l);
    }

    public void it(TreeNode root, List<Integer> l) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode temp = stack.pop();
            l.add(temp.val);
            curr = temp.right;
        }
    }
}