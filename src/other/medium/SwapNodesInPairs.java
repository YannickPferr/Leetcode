package other.medium;

import utils.linkedlist.ListNode;

/**
 * Problem: 24. Swap Nodes in Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsswap-nodes-in-pairs
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode slow = head;
        ListNode fast = slow == null ? null : slow.next;
        while (slow != null && fast != null) {
            ListNode tail = fast.next;
            fast.next = slow;
            slow.next = tail;
            prev.next = fast;
            prev = slow;
            slow = tail;
            fast = slow == null ? null : slow.next;
        }
        return dummyHead.next;
    }
}