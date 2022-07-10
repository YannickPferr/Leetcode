package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 150. Evaluate Reverse Polish Notation
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsevaluate-reverse-polish-notation
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calc(a, b, token));
            } else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    public boolean isOperator(String token) {
        switch (token) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            default:
                return false;
        }
    }

    public int calc(int a, int b, String token) {
        switch (token) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}