package other.medium;

import utils.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 1110. Delete Nodes And Return Forest
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdelete-nodes-and-return-forest
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
public class DeleteNodesAndReturnForest {
    List<TreeNode> l = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] toDelete = new boolean[10001];
        for (int delete : to_delete)
            toDelete[delete] = true;
        if (root != null && !toDelete[root.val])
            l.add(root);
        rec(root, toDelete);
        return l;
    }

    public TreeNode rec(TreeNode node, boolean[] toDelete) {
        if (node == null)
            return null;

        node.left = rec(node.left, toDelete);
        node.right = rec(node.right, toDelete);

        if (toDelete[node.val]) {
            if (node.left != null && !toDelete[node.left.val])
                l.add(node.left);
            if (node.right != null && !toDelete[node.right.val])
                l.add(node.right);

            return null;
        }
        return node;
    }
}