package other.medium;

/**
 * Problem: 1823. Find the Winner of the Circular Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-the-winner-of-the-circular-game
 */
public class FindTheWinnerOfTheCircularGame {

    class ListNode {
        ListNode prev;
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public int findTheWinner(int n, int k) {
        ListNode head = new ListNode(1);
        ListNode prev = head;
        for (int i = 2; i <= n; i++) {
            ListNode node = new ListNode(i);
            node.prev = prev;
            prev.next = node;
            prev = node;
        }
        prev.next = head;
        head.prev = prev;

        int count = 1;
        ListNode node = head;
        while (node.next != node) {
            if (count == k) {
                remove(node);
                count = 0;
            }
            node = node.next;
            count++;
        }

        return node.val;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}