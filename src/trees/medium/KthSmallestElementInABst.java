package trees.medium;
/**
 * Problem: 230. Kth Smallest Element in a BST
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst
 */

import java.util.ArrayList;
import java.util.List;

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
public class KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        return l.get(k - 1);
    }

    public void dfs(TreeNode root, List<Integer> l) {
        if (root == null)
            return;

        dfs(root.left, l);
        l.add(root.val);
        dfs(root.right, l);
    }
}