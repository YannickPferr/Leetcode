package other.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Problem: 895. Maximum Frequency Stack
 * Difficulty: Hard
 * Link: https://leetcode.com/problemsmaximum-frequency-stack
 */
class FreqStack {

    HashMap<Integer, Integer> count = new HashMap<>();
    HashMap<Integer, Deque<Integer>> freqStack = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {

    }

    public void push(int val) {
        int currentCount = count.getOrDefault(val, 0);
        count.put(val, currentCount + 1);
        Deque<Integer> stack = freqStack.getOrDefault(currentCount + 1, new ArrayDeque<>());
        stack.push(val);
        freqStack.put(currentCount + 1, stack);
        maxFreq = Math.max(maxFreq, currentCount + 1);
    }

    public int pop() {
        int val = freqStack.get(maxFreq).pop();
        if (freqStack.get(maxFreq).isEmpty()) {
            freqStack.remove(maxFreq);
            maxFreq--;
        }
        count.put(val, count.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */


