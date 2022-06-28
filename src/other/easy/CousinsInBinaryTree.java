package other.easy;

/**
 * Problem: 993. Cousins in Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problemscousins-in-binary-tree
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
public class CousinsInBinaryTree {

    class Node {
        TreeNode parent;
        int depth;

        public Node(TreeNode parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }

    Node[] pair;

    public boolean isCousins(TreeNode root, int x, int y) {
        pair = new Node[2];
        dfs(root, x, y, null, 0);
        return pair[0].parent != pair[1].parent && pair[0].depth == pair[1].depth;
    }

    public void dfs(TreeNode node, int x, int y, TreeNode parent, int depth) {
        if (node == null)
            return;

        if (node.val == x)
            pair[0] = new Node(parent, depth);
        if (node.val == y)
            pair[1] = new Node(parent, depth);
        dfs(node.left, x, y, node, depth + 1);
        dfs(node.right, x, y, node, depth + 1);
    }
}