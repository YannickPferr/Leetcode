package other.medium;

import utils.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Problem: 314. Binary Tree Vertical Order Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsbinary-tree-vertical-order-traversal
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
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> all = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> row : map.values()) {
            List<Integer> l = new ArrayList<>();
            for (List<Integer> subL : row.values())
                l.addAll(subL);
            all.add(l);
        }
        return all;
    }

    public void dfs(TreeNode node, int i, int j, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (node == null)
            return;

        TreeMap<Integer, List<Integer>> row = map.getOrDefault(j, new TreeMap<>());
        List<Integer> l = row.getOrDefault(i, new ArrayList<>());
        l.add(node.val);
        row.put(i, l);
        map.put(j, row);
        dfs(node.left, i + 1, j - 1, map);
        dfs(node.right, i + 1, j + 1, map);
    }
}