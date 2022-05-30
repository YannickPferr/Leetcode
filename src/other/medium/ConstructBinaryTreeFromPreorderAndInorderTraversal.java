package other.medium;

/**
 * Problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsconstruct-binary-tree-from-preorder-and-inorder-traversal
 */

import java.util.HashMap;

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
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    HashMap<Integer, Integer> indexLookup = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            indexLookup.put(inorder[i], i);
        return rec(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode rec(int[] preorder, int[] inorder, int rootStart, int start, int end) {
        if (end < start)
            return null;

        TreeNode root = new TreeNode(preorder[rootStart]);
        int rootIndex = indexLookup.get(root.val);
        int leftSize = rootIndex - start;
        root.left = rec(preorder, inorder, rootStart + 1, start, rootIndex - 1);
        root.right = rec(preorder, inorder, rootStart + 1 + leftSize, rootIndex + 1, end);


        return root;
    }
}