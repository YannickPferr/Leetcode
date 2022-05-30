package heap.easy;

import java.util.PriorityQueue;

/**
 * Problem: 1046. Last Stone Weight
 * Difficulty: Easy
 * Link: https://leetcode.com/problemslast-stone-weight
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones)
            heap.add(stone);

        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            if (x != y)
                heap.add(Math.abs(x - y));
        }

        if (heap.isEmpty())
            return 0;

        return heap.poll();
    }
}