package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 155. Min Stack
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmin-stack
 */
class MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Integer[] minStack;
    int min = 0;

    public MinStack() {
        minStack = new Integer[3 * (int) Math.pow(10, 4)];
    }

    public void push(int val) {
        stack.push(val);
        if (min == 0 || val <= minStack[min - 1])
            minStack[min++] = val;
    }

    public void pop() {
        int removed = stack.pop();
        if (removed == minStack[min - 1])
            minStack[min-- - 1] = null;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack[min - 1];
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */