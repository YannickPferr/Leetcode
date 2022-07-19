package greedy.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 678. Valid Parenthesis String
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsvalid-parenthesis-string
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Deque<Integer> brackets = new ArrayDeque<>();
        Deque<Integer> stars = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*')
                stars.push(i);
            else if (c == '(')
                brackets.push(i);
            else {
                if (!brackets.isEmpty())
                    brackets.pop();
                else if (!stars.isEmpty())
                    stars.pop();
                else
                    return false;
            }
        }

        while (!brackets.isEmpty() && !stars.isEmpty()) {
            if (brackets.pop() > stars.pop())
                return false;
        }

        return brackets.isEmpty();
    }
}