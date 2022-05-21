package linkedlist.easy;

import linkedlist.ListNode;

/**
 * Problem: 206. Reverse Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-linked-list/
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
