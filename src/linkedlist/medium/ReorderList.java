package linkedlist.medium;

import utils.linkedlist.ListNode;
/**
 * Problem: 143. Reorder List
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsreorder-list
 */

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

    public void print(ListNode head) {
        if (head == null)
            return;

        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
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