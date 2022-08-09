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
        int cost;
        int src;
        int dst;
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
            HashSet<Edge> edges = graph.getOrDefault(flight[0], new HashSet<>());
            edges.add(new Edge(flight[0], flight[1], flight[2], 0));
            graph.put(flight[0], edges);
        }

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for (Edge e : graph.getOrDefault(src, new HashSet<>()))
            minHeap.add(e);
        HashMap<Integer, Integer> min = new HashMap<>();
        while (!minHeap.isEmpty()) {
            Edge curr = minHeap.poll();
            if (curr.stops > min.getOrDefault(curr.dst, Integer.MAX_VALUE))
                continue;
            if (curr.dst == dst)
                return curr.cost;
            if (curr.stops == k)
                continue;

            min.put(curr.dst, curr.stops);
            for (Edge e : graph.getOrDefault(curr.dst, new HashSet<>()))
                minHeap.add(new Edge(e.src, e.dst, e.cost + curr.cost, curr.stops + 1));
        }

        return -1;
    }
}