package other.medium;

import utils.linkedlist.ListNode;

/**
 * Problem: 2181. Merge Nodes in Between Zeros
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmerge-nodes-in-between-zeros
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
public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            int sum = 0;
            while (p2.val != 0) {
                sum += p2.val;
                p2 = p2.next;
            }
            ListNode newNode = new ListNode(sum);
            p1.next = newNode;
            p2 = p2.next;
            p1 = newNode;
        }
        return head.next;
    }
}