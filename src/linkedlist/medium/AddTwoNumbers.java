package linkedlist.medium;

import utils.linkedlist.ListNode;

/**
 * Problem: 2. Add Two Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsadd-two-numbers
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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode node = head;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int val = a + b + carry;
            if (val >= 10)
                carry = 1;
            else
                carry = 0;
            val %= 10;
            node.next = new ListNode(val);
            node = node.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1)
            node.next = new ListNode(1);

        return head.next;
    }
}