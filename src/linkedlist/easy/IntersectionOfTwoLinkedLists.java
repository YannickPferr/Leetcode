package linkedlist.easy;

import utils.linkedlist.ListNode;
/**
 * Problem: 160. Intersection of Two Linked Lists
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsintersection-of-two-linked-lists
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode l = headA;
        ListNode r = headB;
        while (l != r) {
            l = l == null ? headB : l.next;
            r = r == null ? headA : r.next;
        }

        return l;
    }
}