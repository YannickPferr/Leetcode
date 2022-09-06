package other.medium;

import utils.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Problem: 654. Maximum Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximum-binary-tree
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
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int rootVal = 0;
        Deque<Integer> right = new ArrayDeque<>();
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            rootVal = Math.max(nums[i], rootVal);
            int lastRemoved = -1;
            while (!right.isEmpty() && right.peek() < nums[i])
                lastRemoved = right.pop();
            map.put(nums[i], new int[]{-1, lastRemoved});
            right.push(nums[i]);
        }

        Deque<Integer> left = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int lastRemoved = -1;
            while (!left.isEmpty() && left.peek() < nums[i])
                lastRemoved = left.pop();
            map.get(nums[i])[0] = lastRemoved;
            left.push(nums[i]);
        }

        return buildTree(map, rootVal);
    }

    public TreeNode buildTree(HashMap<Integer, int[]> map, int nodeVal) {
        if (!map.containsKey(nodeVal))
            return null;

        TreeNode node = new TreeNode(nodeVal);
        node.left = buildTree(map, map.get(nodeVal)[0]);
        node.right = buildTree(map, map.get(nodeVal)[1]);
        return node;
    }
}