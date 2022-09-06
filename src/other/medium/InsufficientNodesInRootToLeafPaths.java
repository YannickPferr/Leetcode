package other.medium;

import utils.trees.TreeNode;

import java.util.HashMap;

/**
 * Problem: 1080. Insufficient Nodes in Root to Leaf Paths
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsinsufficient-nodes-in-root-to-leaf-paths
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
public class InsufficientNodesInRootToLeafPaths {
    HashMap<TreeNode, Integer> hm = new HashMap<>();

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int max = dfs(root, limit, 0);
        if (max < limit)
            return null;
        return root;
    }

    public int dfs(TreeNode node, int limit, int pathLen) {
        if (node.left == null && node.right == null)
            return node.val + pathLen;

        int left = node.left != null ? dfs(node.left, limit, pathLen + node.val) : Integer.MIN_VALUE;
        if (left < limit)
            node.left = null;
        int right = node.right != null ? dfs(node.right, limit, pathLen + node.val) : Integer.MIN_VALUE;
        if (right < limit)
            node.right = null;
        return Math.max(left, right);
    }
}