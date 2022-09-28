package other.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Problem: 744. Find Smallest Letter Greater Than Target
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-smallest-letter-greater-than-target
 */
public class FindSmallestLetterGreaterThanTarget {
    class Path {
        int neighbor;
        int cost;

        public Path(int neighbor, int cost) {
            this.neighbor = neighbor;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashSet<Path>> adjacencyList = new HashMap<>();
        for (int[] time : times) {
            HashSet<Path> paths = adjacencyList.getOrDefault(time[0], new HashSet<>());
            paths.add(new Path(time[1], time[2]));
            adjacencyList.put(time[0], paths);
        }
        if (!adjacencyList.containsKey(k))
            return -1;

        PriorityQueue<Path> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        minHeap.add(new Path(k, 0));
        int delayTime = 0;
        HashSet<Integer> visited = new HashSet<>();
        while (!minHeap.isEmpty()) {
            int size = minHeap.size();
            for (int i = 0; i < size; i++) {
                Path p = minHeap.poll();
                if (visited.contains(p.neighbor))
                    continue;

                visited.add(p.neighbor);
                delayTime = Math.max(delayTime, p.cost);
                HashSet<Path> paths = adjacencyList.getOrDefault(p.neighbor, new HashSet<>());
                for (Path p2 : paths) {
                    p2.cost += p.cost;
                    minHeap.add(p2);
                }
            }
        }

        return visited.size() == n ? delayTime : -1;
    }
}