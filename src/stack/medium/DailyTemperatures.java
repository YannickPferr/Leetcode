package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 739. Daily Temperatures
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdaily-temperatures
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int poppedIdx = stack.pop();
                answer[poppedIdx] = i - poppedIdx;
            }
            stack.push(i);
        }
        return answer;
    }
}