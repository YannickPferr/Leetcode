package stack.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 20. Valid Parentheses
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsvalid-parentheses
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpenBracket(c))
                stack.push(c);
            else if (stack.isEmpty() || !isMatchingBracket(stack.pop(), c))
                return false;
        }
        return stack.isEmpty();
    }

    public boolean isOpenBracket(char c) {
        if (c == '(' || c == '[' || c == '{')
            return true;
        return false;
    }

    public boolean isMatchingBracket(char a, char b) {
        if ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'))
            return true;
        return false;
    }
}