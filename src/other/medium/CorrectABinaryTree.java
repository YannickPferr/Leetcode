package other.medium;

import utils.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Problem: 1660. Correct a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscorrect-a-binary-tree
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
public class CorrectABinaryTree {
    HashMap<Integer, Integer> parents = new HashMap<>();

    public TreeNode correctBinaryTree(TreeNode root) {
        TreeNode invalid = findInvalid(root);
        removeInvalid(root, invalid);
        return root;
    }

    public TreeNode findInvalid(TreeNode node) {
        HashSet<TreeNode> seen = new HashSet<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(node);
        seen.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (seen.contains(curr.right))
                    return curr;

                if (curr.left != null) {
                    q.add(curr.left);
                    seen.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    seen.add(curr.right);
                }
            }
        }
        return null;
    }

    public void removeInvalid(TreeNode node, TreeNode invalid) {
        if (node == null)
            return;

        if (node.left == invalid)
            node.left = null;
        else if (node.right == invalid)
            node.right = null;
        removeInvalid(node.left, invalid);
        removeInvalid(node.right, invalid);
    }
}