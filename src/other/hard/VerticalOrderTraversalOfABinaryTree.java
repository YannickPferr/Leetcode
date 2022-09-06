package other.hard;

import utils.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Problem: 987. Vertical Order Traversal of a Binary Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problemsvertical-order-traversal-of-a-binary-tree
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
public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> hm = new TreeMap<>();
        dfs(root, 0, 0, hm);
        List<List<Integer>> l = new ArrayList<>();
        for (int col : hm.keySet()) {
            List<Integer> allRows = new ArrayList<>();
            for (int row : hm.get(col).keySet()) {
                List<Integer> r = hm.get(col).get(row);
                Collections.sort(r);
                allRows.addAll(r);
            }
            l.add(allRows);
        }
        return l;
    }

    public void dfs(TreeNode node, int row, int col, TreeMap<Integer, TreeMap<Integer, List<Integer>>> hm) {
        if (node == null)
            return;

        TreeMap<Integer, List<Integer>> rowMap = hm.getOrDefault(col, new TreeMap<>());
        List<Integer> l = rowMap.getOrDefault(row, new ArrayList<>());
        l.add(node.val);
        rowMap.put(row, l);
        hm.put(col, rowMap);
        dfs(node.left, row + 1, col - 1, hm);
        dfs(node.right, row + 1, col + 1, hm);
    }
}