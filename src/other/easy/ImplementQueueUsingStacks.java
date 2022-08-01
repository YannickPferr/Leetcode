package other.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 232. Implement Queue using Stacks
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsimplement-queue-using-stacks
 */
class MyQueue {

    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        peek();
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */