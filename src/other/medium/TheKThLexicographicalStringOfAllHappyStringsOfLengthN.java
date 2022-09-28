package other.medium;

import java.util.Arrays;
import java.util.List;

/**
 * Problem: 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsthe-k-th-lexicographical-string-of-all-happy-strings-of-length-n
 */
public class TheKThLexicographicalStringOfAllHappyStringsOfLengthN {
    List<Character> chars = Arrays.asList('a', 'b', 'c');
    int count = 0;

    public String getHappyString(int n, int k) {
        return backtracking(n, k, new StringBuilder());
    }

    public String backtracking(int n, int k, StringBuilder sb) {
        if (sb.length() == n) {
            count++;
            if (count == k)
                return sb.toString();
            else
                return "";
        }

        for (char c : chars) {
            if (sb.length() >= 1 && sb.charAt(sb.length() - 1) == c)
                continue;

            sb.append(c);
            String ret = backtracking(n, k, sb);
            if (ret.length() > 0)
                return ret;
            sb.deleteCharAt(sb.length() - 1);
        }

        return "";
    }
}