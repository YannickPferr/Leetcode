package other.medium;

import utils.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 1116. Print Zero Even Odd
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsprint-zero-even-odd
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
public class PrintZeroEvenOdd {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}