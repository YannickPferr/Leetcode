package linkedlist.medium;

import linkedlist.ListNode;
import linkedlist.Node;

import java.util.HashMap;

/**
 * Problem: 138. Copy List with Random Pointer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node newHead = new Node(0);
        Node newPtr = newHead;
        Node node = head;
        HashMap<Node, Node> map = new HashMap<>();
        while(node != null){
            newPtr.next = new Node(node.val);
            newPtr = newPtr.next;
            map.put(node, newPtr);
            node = node.next;
        }

        node = head;
        while(node != null){
            Node newNode = map.get(node);
            newNode.random = map.getOrDefault(node.random, null);
            node = node.next;
        }

        return newHead.next;
    }
}
