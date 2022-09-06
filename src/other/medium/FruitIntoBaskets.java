package other.medium;

import utils.trees.TreeNode;

import java.util.ArrayList;

/**
 * Problem: 904. Fruit Into Baskets
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfruit-into-baskets
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
public class FruitIntoBaskets {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> seq1 = new ArrayList<>();
        ArrayList<Integer> seq2 = new ArrayList<>();
        getLeafSequence(root1, seq1);
        getLeafSequence(root2, seq2);
        return seq1.equals(seq2);
    }

    public void getLeafSequence(TreeNode node, ArrayList<Integer> seq) {
        if (node == null)
            return;

        if (node.left == null && node.right == null)
            seq.add(node.val);

        getLeafSequence(node.left, seq);
        getLeafSequence(node.right, seq);
    }
}