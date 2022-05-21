package linkedlist.medium;

import linkedlist.ListNode;

/**
 * Problem: 19. Remove Nth Node From End of List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //find nth node
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        int i = 0;
        while(fast.next != null){
            if(i >= n)
                slow = slow.next;
            fast = fast.next;
            i++;
        }

        slow.next = slow.next.next;
        return start.next;
    }
}
