package other.easy;
/**
 * Problem: 257. Binary Tree Paths
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-tree-paths
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
public class BinaryTreePaths {
    List<String> l = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return l;
    }

    public void dfs(TreeNode node, String s) {
        if (node == null)
            return;

        s += String.valueOf(node.val);
        if (node.left == null && node.right == null)
            l.add(s);
        else
            s += "->";

        dfs(node.left, s);
        dfs(node.right, s);
    }
}