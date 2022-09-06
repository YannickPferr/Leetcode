package other.medium;

import utils.trees.TreeNode;

/**
 * Problem: 1008. Construct Binary Search Tree from Preorder Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsconstruct-binary-search-tree-from-preorder-traversal
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
public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return rec(preorder, 0, preorder.length);
    }

    public TreeNode rec(int[] preorder, int start, int end) {
        if (start >= end)
            return null;
        TreeNode root = new TreeNode(preorder[start]);
        int idxOfFirstBiggerVal = start + 1;
        while (idxOfFirstBiggerVal < end && preorder[idxOfFirstBiggerVal] <= preorder[start])
            idxOfFirstBiggerVal++;
        root.left = rec(preorder, start + 1, idxOfFirstBiggerVal);
        root.right = rec(preorder, idxOfFirstBiggerVal, end);
        return root;
    }
}