package heap.easy;

import java.util.PriorityQueue;

/**
 * Problem: 703. Kth Largest Element in a Stream
 * Difficulty: Easy
 * Link: https://leetcode.com/problemskth-largest-element-in-a-stream
 */
class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums)
            add(num);
    }

    public int add(int val) {
        if (minHeap.size() < k)
            minHeap.add(val);
        else if (val > minHeap.peek().intValue()) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */