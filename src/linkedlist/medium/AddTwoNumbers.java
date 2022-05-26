package linkedlist.medium;
/**
 * Problem: 2. Add Two Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/add-two-numbers
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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode r = result;
        ListNode n = l1;
        ListNode n2 = l2;
        int carry = 0;
        while (n != null || n2 != null) {
            int val1 = n == null ? 0 : n.val;
            int val2 = n2 == null ? 0 : n2.val;
            r.next = new ListNode((val1 + val2 + carry) % 10);
            carry = (val1 + val2 + carry) / 10;
            r = r.next;
            if (n != null)
                n = n.next;
            if (n2 != null)
                n2 = n2.next;
        }
        if (carry != 0)
            r.next = new ListNode(carry);

        return result.next;
    }
}