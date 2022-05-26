package graphs.medium;

import java.util.HashMap;

/**
 * Problem: 133. Clone Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/clone-graph
 */
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

public class CloneGraph {
    HashMap<Node, Node> copied = new HashMap<>();

    public Node cloneGraph(Node node) {
        Node newNode = cloneRec(node);
        return newNode;
    }

    public Node cloneRec(Node node) {
        if (node == null)
            return null;

        Node newNode = new Node(node.val);
        copied.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            if (copied.containsKey(neighbor))
                newNode.neighbors.add(copied.get(neighbor));
            else
                newNode.neighbors.add(cloneRec(neighbor));
        }
        return newNode;
    }
}