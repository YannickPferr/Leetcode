package other.easy; /**
 * Problem: 234. Palindrome Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problemspalindrome-linked-list
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
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next == null ? null : fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;

            prev = slow;
            slow = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = prev;
        ListNode right = slow;
        while (left != null && right != null) {
            if (left.val != right.val)
                return false;

            left = left.next;
            right = right.next;
        }

        return true;
    }
}