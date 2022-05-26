package trees.medium;
/**
 * Problem: 199. Binary Tree Right Side View
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-right-side-view
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> l = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            int last = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.removeFirst();
                last = node.val;
                if (node.left != null)
                    q.addLast(node.left);
                if (node.right != null)
                    q.addLast(node.right);
            }
            l.add(last);
        }

        return l;
    }
}