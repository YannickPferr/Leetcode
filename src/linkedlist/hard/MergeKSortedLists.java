package linkedlist.hard;

import utils.linkedlist.ListNode;

/**
 * Problem: 23. Merge k Sorted Lists
 * Difficulty: Hard
 * Link: https://leetcode.com/problemsmerge-k-sorted-lists
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
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (end - start <= 0)
            return null;
        if (end - start == 1)
            return lists[start];
        if (end - start == 2)
            return mergeLists(lists[start], lists[end - 1]);

        int middle = start + (end - start) / 2;
        return mergeLists(mergeKLists(lists, start, middle), mergeKLists(lists, middle, end));
    }

    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode();
        ListNode head = newList;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newList.next = l1;
                l1 = l1.next;
            } else {
                newList.next = l2;
                l2 = l2.next;
            }
            newList = newList.next;
        }
        if (l1 != null)
            newList.next = l1;
        else
            newList.next = l2;
        return head.next;
    }
}