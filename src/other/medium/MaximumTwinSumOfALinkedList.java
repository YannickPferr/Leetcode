package other.medium;

import utils.linkedlist.ListNode;

/**
 * Problem: 2130. Maximum Twin Sum of a Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximum-twin-sum-of-a-linked-list
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
public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversed = slow.next;
        slow.next = null;
        reversed = reverse(reversed, null);

        ListNode node = head;
        int max = 0;
        while (node != null && reversed != null) {
            max = Math.max(max, node.val + reversed.val);
            node = node.next;
            reversed = reversed.next;
        }

        return max;
    }

    public ListNode reverse(ListNode node, ListNode prev) {
        if (node == null)
            return prev;
        ListNode tail = node.next;
        node.next = prev;
        return reverse(tail, node);
    }
}