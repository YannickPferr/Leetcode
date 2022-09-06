package slidingwindow.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 239. Sliding Window Maximum
 * Difficulty: Hard
 * Link: https://leetcode.com/problemssliding-window-maximum
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int j = 0;
        int[] out = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - (k - 1))
                deque.poll();
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();
            deque.add(i);
            if (i >= k - 1)
                out[j++] = nums[deque.peek()];
        }

        return out;
    }
}