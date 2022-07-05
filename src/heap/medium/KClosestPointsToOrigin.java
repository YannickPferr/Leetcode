package heap.medium;

import java.util.PriorityQueue;

/**
 * Problem: 973. K Closest Points to Origin
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsk-closest-points-to-origin
 */
public class KClosestPointsToOrigin {
    class Point {
        int distTo0;
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            distTo0 = dist(x, y);
        }

        public int dist(int x, int y) {
            return (int) Math.pow(x, 2) + (int) Math.pow(y, 2);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<Point>((a, b) -> b.distTo0 - a.distTo0);
        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);
            if (heap.size() < k)
                heap.add(p);
            else if (p.distTo0 < heap.peek().distTo0) {
                heap.poll();
                heap.add(p);
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point point = heap.poll();
            result[i] = new int[]{point.x, point.y};
        }
        return result;
    }


}