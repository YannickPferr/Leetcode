package advancedgraphs.medium;

import java.util.PriorityQueue;

/**
 * Problem: 1584. Min Cost to Connect All Points
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmin-cost-to-connect-all-points
 */
public class MinCostToConnectAllPoints {
    public class Edge {
        int src;
        int dst;
        int len;

        public Edge(int src, int dst, int len) {
            this.src = src;
            this.dst = dst;
            this.len = len;
        }
    }

    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;
        return find(parent[x]);
    }

    int[] parent;

    public int minCostConnectPoints(int[][] points) {
        parent = new int[points.length];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.len - b.len);
        for (int i = 0; i < points.length; i++) {
            parent[i] = i;
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                int manhattanDist = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
                minHeap.add(new Edge(i, j, manhattanDist));
            }
        }

        int cost = 0;
        int edges = 0;
        while (!minHeap.isEmpty() && edges < points.length - 1) {
            Edge e = minHeap.poll();
            if (find(e.src) != find(e.dst)) {
                union(e.src, e.dst);
                cost += e.len;
                edges++;
            }
        }
        return cost;
    }
}