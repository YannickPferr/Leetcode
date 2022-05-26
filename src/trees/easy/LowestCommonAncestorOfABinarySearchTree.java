package trees.easy;
/**
 * Problem: 235. Lowest Common Ancestor of a Binary Search Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val < Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
}