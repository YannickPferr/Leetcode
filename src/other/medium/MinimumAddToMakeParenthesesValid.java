package other.medium;

/**
 * Problem: 921. Minimum Add to Make Parentheses Valid
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-add-to-make-parentheses-valid
 */
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int closed = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                open++;
            else if (open > 0)
                open--;
            else
                closed++;
        }
        return open + closed;
    }
}