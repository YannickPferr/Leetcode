package linkedlist.easy;

import utils.linkedlist.ListNode;

/**
 * Problem: 21. Merge Two Sorted Lists
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmerge-two-sorted-lists
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
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(0);
        ListNode curr = newList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = new ListNode(list2.val);
                curr = curr.next;
                list2 = list2.next;
            }
        }

        if (list1 == null)
            curr.next = list2;
        if (list2 == null)
            curr.next = list1;

        return newList.next;
    }
}