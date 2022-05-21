package trees.easy;

import trees.TreeNode;

/**
 * Problem: 100. Same Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null && q != null)
            return false;
        if (p != null && q == null)
            return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
