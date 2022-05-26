package heap.easy;

import java.util.PriorityQueue;

/**
 * Problem: 703. Kth Largest Element in a Stream
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/kth-largest-element-in-a-stream
 */
class KthLargest {

    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>((a, b) -> a - b);
        for (int i : nums)
            heap.add(i);
        this.k = k;
    }

    public int add(int val) {
        heap.add(val);
        while (heap.size() > k)
            heap.poll();

        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */