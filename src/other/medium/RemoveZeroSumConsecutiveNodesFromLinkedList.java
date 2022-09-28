package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 1171. Remove Zero Sum Consecutive Nodes from Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsremove-zero-sum-consecutive-nodes-from-linked-list
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Deque<int[]> q = new ArrayDeque<>();
        if (grid[0][0] == 0)
            q.add(new int[]{0, 0});
        int pathLen = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cell = q.poll();
                int i = cell[0];
                int j = cell[1];
                if (i == grid.length - 1 && j == grid[0].length - 1)
                    return pathLen;

                for (int[] dir : dirs) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];
                    if (newI >= grid.length || newI < 0 || newJ >= grid[0].length || newJ < 0 || grid[newI][newJ] != 0)
                        continue;
                    grid[newI][newJ] = 1;
                    q.add(new int[]{newI, newJ});
                }
            }
            pathLen++;
        }
        return -1;
    }
}

