package graphs.medium;

import graphs.Node;

import java.util.HashMap;

/**
 * Problem: 133. Clone Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/clone-graph/
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
