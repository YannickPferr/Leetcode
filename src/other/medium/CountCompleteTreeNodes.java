package other.medium;

import utils.trees.TreeNode;

/**
 * Problem: 222. Count Complete Tree Nodes
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscount-complete-tree-nodes
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
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {

        int height = height(root);
        int l = 1;
        int r = (int) Math.pow(2, height - 1) + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (!nodeExists(root, height, m))
                r = m;
            else
                l = m + 1;
        }
        int numNodes = (int) (Math.pow(2, height - 1) - 1) + (l - 1);
        return numNodes;
    }

    public boolean nodeExists(TreeNode root, int height, int nodeNum) {
        if (root == null)
            return false;
        if (height == 1)
            return true;

        int nodesLastLevelMax = (int) Math.pow(2, height - 1);
        int half = nodesLastLevelMax / 2;
        if (nodeNum > half)
            return nodeExists(root.right, height - 1, nodeNum - half);
        else
            return nodeExists(root.left, height - 1, nodeNum);
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;
        return height(node.left) + 1;
    }
}