package linkedlist.easy; /**
 * Problem: 206. Reverse Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsreverse-linked-list
 */

import utils.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        return rec(head, null);
    }

    public ListNode rec(ListNode head, ListNode prev) {
        if (head == null)
            return prev;

        ListNode tail = head.next;
        head.next = prev;
        return rec(tail, head);
    }
}