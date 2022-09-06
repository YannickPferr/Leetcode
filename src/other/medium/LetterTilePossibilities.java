package other.medium;

import utils.trees.TreeNode;

/**
 * Problem: 1079. Letter Tile Possibilities
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsletter-tile-possibilities
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
public class LetterTilePossibilities {
    public int sumRootToLeaf(TreeNode root) {
        return rec(root, new StringBuilder());
    }

    public int rec(TreeNode node, StringBuilder path) {
        if (node.left == null && node.right == null)
            return Integer.parseInt(path.toString() + node.val, 2);

        path.append(node.val);
        int left = node.left == null ? 0 : rec(node.left, path);
        int right = node.right == null ? 0 : rec(node.right, path);
        path.deleteCharAt(path.length() - 1);
        return left + right;
    }
}