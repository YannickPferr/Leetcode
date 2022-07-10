package stack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 22. Generate Parentheses
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsgenerate-parentheses
 */
public class GenerateParentheses {

    List<String> all = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        rec(n, n, new StringBuilder());
        return all;
    }

    public void rec(int openLeft, int closedLeft, StringBuilder current) {
        if (openLeft == 0 && closedLeft == 0)
            all.add(current.toString());
        else {
            if (openLeft == closedLeft) {
                current.append("(");
                rec(openLeft - 1, closedLeft, current);
                current.deleteCharAt(current.length() - 1);
            } else if (openLeft < closedLeft) {
                if (openLeft > 0) {
                    current.append("(");
                    rec(openLeft - 1, closedLeft, current);
                    current.deleteCharAt(current.length() - 1);
                }

                if (closedLeft > 0) {
                    current.append(")");
                    rec(openLeft, closedLeft - 1, current);
                    current.deleteCharAt(current.length() - 1);
                }
            }
        }
    }
}