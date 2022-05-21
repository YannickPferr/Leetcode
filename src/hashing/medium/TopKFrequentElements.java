package hashing.medium;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Problem: 347. Top K Frequent Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums)
            count.put(i, count.getOrDefault(i, 0) + 1);

        int[] pair = new int[2];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i : count.keySet()) {
            pair[0] = i;
            pair[1] = count.get(i);
            heap.add(pair);
            pair = new int[2];
        }

        int[] out = new int[k];
        for (int i = 0; i < k; i++)
            out[i] = heap.poll()[0];

        return out;
    }
}
