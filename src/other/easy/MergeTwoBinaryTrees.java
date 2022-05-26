package other.easy;
/**
 * Problem: 617. Merge Two Binary Trees
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-two-binary-trees
 */

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
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        return mergeTreesRec(root1, root2);
    }

    public TreeNode mergeTreesRec(TreeNode root1, TreeNode root2) {

        if (root1 != null && root2 != null) {
            TreeNode newRoot = new TreeNode(root1.val + root2.val);
            newRoot.left = mergeTreesRec(root1.left, root2.left);
            newRoot.right = mergeTreesRec(root1.right, root2.right);
            return newRoot;
        } else if (root1 != null)
            return root1;
        else if (root2 != null)
            return root2;

        return null;
    }
}