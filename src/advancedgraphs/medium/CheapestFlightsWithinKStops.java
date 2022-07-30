package advancedgraphs.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Problem: 787. Cheapest Flights Within K Stops
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscheapest-flights-within-k-stops
 */
public class CheapestFlightsWithinKStops {

    class Edge {
        int src;
        int dst;
        int cost;
        int stops;

        public Edge(int src, int dst, int cost, int stops) {
            this.src = src;
            this.dst = dst;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashSet<Edge>> graph = new HashMap<>();
        for (int[] flight : flights) {
            HashSet<Edge> hs = graph.getOrDefault(flight[0], new HashSet<>());
            hs.add(new Edge(flight[0], flight[1], flight[2], 0));
            graph.put(flight[0], hs);
        }

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for (Edge e : graph.getOrDefault(src, new HashSet<>()))
            minHeap.add(e);
        int[] visited = new int[n];
        for (int i = 0; i < n; i++)
            visited[i] = Integer.MAX_VALUE;

        visited[src] = 0;
        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            if (edge.dst == dst)
                return edge.cost;

            visited[edge.dst] = edge.stops;
            if (edge.stops < k)
                for (Edge e : graph.getOrDefault(edge.dst, new HashSet<>())) {
                    if (edge.stops + 1 < visited[e.dst]) {
                        minHeap.add(new Edge(e.src, e.dst, e.cost + edge.cost, edge.stops + 1));
                    }
                }
        }
        return -1;
    }
}