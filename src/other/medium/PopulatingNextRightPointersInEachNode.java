package other.medium;

import utils.linkedlist.Node;

/**
 * Problem: 116. Populating Next Right Pointers in Each Node
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspopulating-next-right-pointers-in-each-node
 */
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    public void dfs(Node node) {
        if (node == null)
            return;

        Node curr = node;
        Node prev = null;
        while (curr != null) {
            if (prev != null)
                prev.next = curr.left;
            if (curr.left != null)
                curr.left.next = curr.right;
            prev = curr.right;
            curr = curr.next;
        }
        dfs(node.left);
    }
}