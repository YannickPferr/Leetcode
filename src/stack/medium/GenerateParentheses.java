package stack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 22. Generate Parentheses
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsgenerate-parentheses
 */
public class GenerateParentheses {
    List<String> l = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        rec(n, n, new StringBuilder());
        return l;
    }

    public void rec(int o, int c, StringBuilder sb) {
        if (o == 0 && c == 0)
            l.add(sb.toString());
        else {
            if (o > 0) {
                sb.append("(");
                rec(o - 1, c, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (c > o) {
                sb.append(")");
                rec(o, c - 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}