package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 1249. Minimum Remove to Make Valid Parentheses
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-remove-to-make-valid-parentheses
 */
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int skipped = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(i - skipped);
            else if (c == ')') {
                if (stack.isEmpty()) {
                    skipped++;
                    continue;
                } else
                    stack.pop();
            }
            sb.append(c);
        }

        while (!stack.isEmpty())
            sb.deleteCharAt(stack.pop());
        return sb.toString();
    }
}