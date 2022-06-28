package other.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 1021. Remove Outermost Parentheses
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsremove-outermost-parentheses
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(i));
        stack.push(s.charAt(i++));
        while (!stack.isEmpty()) {
            char c = s.charAt(i++);
            sb.append(c);
            if (c == ')')
                stack.pop();
            else
                stack.push(c);

            if (stack.isEmpty()) {
                result.append(sb.substring(1, sb.length() - 1));
                sb = new StringBuilder();
                if (i < s.length()) {
                    c = s.charAt(i++);
                    sb.append(c);
                    stack.push(c);
                }

            }
        }

        return result.toString();
    }
}