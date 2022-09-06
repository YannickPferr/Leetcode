package heap.medium;

import java.util.PriorityQueue;

/**
 * Problem: 973. K Closest Points to Origin
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsk-closest-points-to-origin
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> dist(b) - dist(a));
        for (int[] point : points) {
            if (maxHeap.size() < k)
                maxHeap.add(point);
            else if (dist(point) < dist(maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.add(point);
            }
        }

        int[][] kClosest = new int[k][2];
        for (int i = k - 1; i >= 0; i--)
            kClosest[i] = maxHeap.poll();
        return kClosest;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}