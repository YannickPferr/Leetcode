package linkedlist.medium;

import linkedlist.ListNode;

import java.util.HashMap;

/**
 * Problem: 143. Reorder List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    int size = 0;

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l = head;
        ListNode r = reverse(slow.next);
        slow.next = null;
        while (l != null & r != null) {
            ListNode tailL = l.next;
            ListNode tailR = r.next;

            l.next = r;
            r.next = tailL;
            l = tailL;
            r = tailR;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null)
            return null;

        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            ListNode tail = node.next;
            node.next = prev;
            prev = node;
            node = tail;
            size++;
        }

        return prev;
    }
}
