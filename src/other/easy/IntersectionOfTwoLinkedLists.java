package other.easy;
/**
 * Problem: 160. Intersection of Two Linked Lists
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/intersection-of-two-linked-lists
 */

import utils.linkedlist.ListNode;

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
public public class IntersectionOfTwoLinkedLists {
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