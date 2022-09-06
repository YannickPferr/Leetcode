package other.medium;

import utils.trees.TreeNode;

import java.util.HashSet;

/**
 * Problem: 1214. Two Sum BSTs
 * Difficulty: Medium
 * Link: https://leetcode.com/problemstwo-sum-bsts
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
public class TwoSumBsts {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> hs = new HashSet<>();
        dfs1(root1, hs);
        return dfs2(root2, hs, target);
    }

    public void dfs1(TreeNode node, HashSet<Integer> hs) {
        if (node == null)
            return;

        hs.add(node.val);
        dfs1(node.left, hs);
        dfs1(node.right, hs);
    }

    public boolean dfs2(TreeNode node, HashSet<Integer> hs, int target) {
        if (node == null)
            return false;
        if (hs.contains(target - node.val))
            return true;

        return dfs2(node.left, hs, target) || dfs2(node.right, hs, target);
    }
}