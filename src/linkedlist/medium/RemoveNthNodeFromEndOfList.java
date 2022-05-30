package linkedlist.medium;

import utils.linkedlist.ListNode;
/**
 * Problem: 19. Remove Nth Node From End of List
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsremove-nth-node-from-end-of-list
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
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //find nth node
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        int i = 0;
        while (fast.next != null) {
            if (i >= n)
                slow = slow.next;
            fast = fast.next;
            i++;
        }

        slow.next = slow.next.next;
        return start.next;
    }
}