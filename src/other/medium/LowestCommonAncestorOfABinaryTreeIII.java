package other.medium;

import utils.linkedlist.Node;

import java.util.HashSet;

/**
 * Problem: 1650. Lowest Common Ancestor of a Binary Tree III
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslowest-common-ancestor-of-a-binary-tree-iii
 */
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

public class LowestCommonAncestorOfABinaryTreeIII {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> parP = new HashSet<>();
        Node curr = p;
        while (curr != null) {
            parP.add(curr);
            curr = curr.parent;
            if (curr == q)
                return q;
        }

        curr = q;
        while (curr != null) {
            if (parP.contains(curr))
                return curr;
            curr = curr.parent;
        }

        return null;
    }
}