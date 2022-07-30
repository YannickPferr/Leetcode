package other.easy;

/**
 * Problem: 237. Delete Node in a Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsdelete-node-in-a-linked-list
 */

import utils.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}