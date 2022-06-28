package other.easy;

/**
 * Problem: 653. Two Sum IV - Input is a BST
 * Difficulty: Easy
 * Link: https://leetcode.com/problemstwo-sum-iv-input-is-a-bst
 */

import java.util.HashSet;

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
public class TwoSumIVInputIsABst {
    HashSet<Integer> hs = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    public boolean dfs(TreeNode node, int k) {
        if (node == null)
            return false;

        if (hs.contains(k - node.val))
            return true;
        hs.add(node.val);

        return dfs(node.left, k) || dfs(node.right, k);
    }
}