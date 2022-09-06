package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 503. Next Greater Element II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnext-greater-element-ii
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] out = new int[nums.length];
        for (int k = 0; k < 2; k++) {
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i])
                    stack.pop();
                out[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i]);
            }
        }

        return out;
    }
}