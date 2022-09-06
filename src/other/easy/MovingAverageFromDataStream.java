package other.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 346. Moving Average from Data Stream
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmoving-average-from-data-stream
 */
class MovingAverage {

    Deque<Integer> window = new ArrayDeque<>();
    double sum = 0;
    int maxSize;

    public MovingAverage(int size) {
        maxSize = size;
    }

    public double next(int val) {
        window.add(val);
        sum += val;
        while (window.size() > maxSize)
            sum -= window.pollFirst();
        return sum / window.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */