package other.easy;

/**
 * Problem: 541. Reverse String II
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsreverse-string-ii
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int end = i + k < s.length() ? i + k : s.length();
            String reversed = reverse(s, i, end, k);
            sb.append(reversed);
            if (end < s.length())
                sb.append(s.substring(end, Math.min(end + k, s.length())));
        }
        return sb.toString();
    }

    public String reverse(String s, int start, int end, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = end - 1; i >= start; i--)
            sb.append(s.charAt(i));
        return sb.toString();
    }
}