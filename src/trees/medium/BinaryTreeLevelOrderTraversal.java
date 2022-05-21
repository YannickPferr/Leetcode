package trees.medium;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Problem: 102. Binary Tree Level Order Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null)
            q.addLast(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.removeFirst();
                if (node.left != null)
                    q.addLast(node.left);
                if (node.right != null)
                    q.addLast(node.right);
                level.add(node.val);
            }
            res.add(level);
        }
        return res;
    }
}
