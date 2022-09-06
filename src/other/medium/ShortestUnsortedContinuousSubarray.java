package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 581. Shortest Unsorted Continuous Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsshortest-unsorted-continuous-subarray
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int start = nums.length - 1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()])
                start = Math.min(start, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()])
                end = Math.max(end, stack.pop());
            stack.push(i);
        }
        if (end <= start)
            return 0;
        return end + 1 - start;
    }
}