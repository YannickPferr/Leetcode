package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2326. Spiral Matrix IV
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsspiral-matrix-iv
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
public class SpiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int i = 0;
        int j = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currDir = 0;
        int[][] mat = new int[m][n];
        for(int[] row : mat)
            Arrays.fill(row, -1);
        while(head != null){
            mat[i][j] = head.val;
            int nextI = i + dirs[currDir][0];
            int nextJ = j + dirs[currDir][1];
            if(nextI == m||nextJ == n||nextI == -1||nextJ == -1||mat[nextI][nextJ] != -1)
                currDir = (currDir + 1) % 4;
            i += dirs[currDir][0];
            j += dirs[currDir][1];
            head = head.next;
        }
        return mat;
    }
}