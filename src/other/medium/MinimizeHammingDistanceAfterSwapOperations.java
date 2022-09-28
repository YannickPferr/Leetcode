package other.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Problem: 1722. Minimize Hamming Distance After Swap Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimize-hamming-distance-after-swap-operations
 */
public class MinimizeHammingDistanceAfterSwapOperations {
    int[] parent;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        parent = new int[source.length];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        for (int[] swap : allowedSwaps)
            union(swap[0], swap[1]);

        HashMap<Integer, HashSet<Integer>> fromTo = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            HashSet<Integer> hs = fromTo.getOrDefault(target[i], new HashSet<>());
            hs.add(i);
            fromTo.put(target[i], hs);
        }

        int hammingDistance = 0;
        loop:
        for (int i = 0; i < source.length; i++)
            if (source[i] != target[i]) {
                for (int to : fromTo.getOrDefault(source[i], new HashSet<>()))
                    if (source[to] != source[i] && find(i) == find(to)) {
                        fromTo.get(source[i]).remove(to);
                        continue loop;
                    }
                hammingDistance++;
            }


        return Math.max(hammingDistance, 0);
    }

    public void union(int x, int y) {
        parent[find(y)] = parent[find(x)];
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}