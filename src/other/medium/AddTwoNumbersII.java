package other.medium;

import utils.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 445. Add Two Numbers II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsadd-two-numbers-ii
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
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> list1 = new ArrayDeque<>();
        while (l1 != null) {
            list1.push(l1.val);
            l1 = l1.next;
        }
        Deque<Integer> list2 = new ArrayDeque<>();
        while (l2 != null) {
            list2.push(l2.val);
            l2 = l2.next;
        }

        ListNode next = null;
        int carry = 0;
        while (!list1.isEmpty() || !list2.isEmpty()) {
            int val1 = !list1.isEmpty() ? list1.pop() : 0;
            int val2 = !list2.isEmpty() ? list2.pop() : 0;
            int res = val1 + val2 + carry;
            if (res >= 10)
                carry = 1;
            else
                carry = 0;
            ListNode node = new ListNode(res % 10);
            node.next = next;
            next = node;
        }
        if (carry == 1) {
            ListNode newHead = new ListNode(carry);
            newHead.next = next;
            return newHead;
        }

        return next;
    }
}