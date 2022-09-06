package other.medium;

import utils.trees.TreeNode;

import java.util.*;

/**
 * Problem: 863. All Nodes Distance K in Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsall-nodes-distance-k-in-binary-tree
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class AllNodesDistanceKInBinaryTree {
    class Node {
        int val;
        List<Node> conns = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }
    }

    HashMap<Integer, Node> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        rec(root, null);
        List<Integer> l = new ArrayList<>();
        int level = 0;
        Deque<Node> q = new ArrayDeque<>();
        q.add(graph.get(target.val));
        boolean[] seen = new boolean[501];
        seen[target.val] = true;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = q.poll();
                if (level == k)
                    l.add(node.val);
                else
                    for (Node n : graph.get(node.val).conns) {
                        if (!seen[n.val]) {
                            seen[n.val] = true;
                            q.add(n);
                        }
                    }
            }
            level++;
        }
        return l;
    }

    public void rec(TreeNode node, Node prev) {
        if (node == null)
            return;

        Node graphNode = new Node(node.val);
        if (prev != null) {
            graphNode.conns.add(prev);
            graph.get(prev.val).conns.add(graphNode);
        }
        graph.put(node.val, graphNode);
        rec(node.left, graphNode);
        rec(node.right, graphNode);
    }
}