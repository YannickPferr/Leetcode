package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 71. Simplify Path
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssimplify-path
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        char prev = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/' && prev == '/')
                continue;
            if (c == '/') {
                if (sb.toString().equals("..")) {
                    deque.pollLast();
                    sb = new StringBuilder();
                    prev = c;
                    continue;
                }
                if (sb.toString().equals(".")) {
                    sb = new StringBuilder();
                    prev = c;
                    continue;
                }

                if (sb.length() > 0)
                    deque.add(sb.toString());
                sb = new StringBuilder();
                prev = c;
                continue;
            }
            sb.append(c);
            prev = c;
        }
        if (sb.length() > 0) {
            if (sb.toString().equals(".."))
                deque.pollLast();
            else if (!sb.toString().equals("."))
                deque.add(sb.toString());
        }

        sb = new StringBuilder();
        sb.append("/");
        for (String s : deque) {
            sb.append(s);
            sb.append("/");
        }
        if (sb.length() > 1)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}