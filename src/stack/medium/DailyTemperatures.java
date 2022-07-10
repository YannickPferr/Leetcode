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
        Deque<Integer[]> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty()) {
                Integer[] last = stack.peek();
                while (temperatures[i] > last[0]) {
                    stack.pop();
                    answer[last[1]] = i - last[1];
                    if (stack.isEmpty())
                        break;
                    last = stack.peek();
                }
            }
            stack.push(new Integer[]{temperatures[i], i});
        }
        return answer;
    }
}