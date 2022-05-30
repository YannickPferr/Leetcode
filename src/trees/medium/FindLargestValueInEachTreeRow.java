package trees.medium;

import utils.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * Problem: 515. Find Largest Value in Each Tree Row
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-largest-value-in-each-tree-row
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
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Integer> l = new ArrayList<>();
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(node.val, max);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            l.add(max);
        }

        return l;
    }
}