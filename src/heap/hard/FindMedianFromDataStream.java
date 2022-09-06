package heap.hard;

import java.util.PriorityQueue;

/**
 * Problem: 295. Find Median from Data Stream
 * Difficulty: Hard
 * Link: https://leetcode.com/problemsfind-median-from-data-stream
 */
class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    double median = 0;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if (right.size() > left.size())
            left.add(right.poll());
    }

    public double findMedian() {
        if (left.size() == right.size())
            return (left.peek() + right.peek()) / 2.0;
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */