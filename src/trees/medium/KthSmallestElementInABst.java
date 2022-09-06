package trees.medium;

import utils.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: 230. Kth Smallest Element in a BST
 * Difficulty: Medium
 * Link: https://leetcode.com/problemskth-smallest-element-in-a-bst
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
public class KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new LinkedList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        int count = 0;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.addLast(node);
                node = node.left;
            }

            node = stack.removeLast();
            count++;
            l.add(node.val);
            if (count == k)
                return node.val;
            node = node.right;
        }

        return 0;
    }
}