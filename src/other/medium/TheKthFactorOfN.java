package other.medium;

import java.util.PriorityQueue;

/**
 * Problem: 1492. The kth Factor of n
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsthe-kth-factor-of-n
 */
public class TheKthFactorOfN {
    public int kthFactor(int n, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i != 0)
                continue;
            int pair = n / i;
            if (pair != i)
                heapAdd(maxHeap, k, pair);
            heapAdd(maxHeap, k, i);
        }
        return maxHeap.size() == k ? maxHeap.peek() : -1;
    }

    public void heapAdd(PriorityQueue<Integer> maxHeap, int k, int el) {
        maxHeap.add(el);
        if (maxHeap.size() > k)
            maxHeap.poll();
    }
}