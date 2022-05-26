package other.easy;

/**
 * Problem: 14. Longest Common Prefix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-common-prefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String curr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            curr = longestPrefix(curr, strs[i]);
            if (curr.equals(""))
                return "";
        }

        return curr;
    }

    public String longestPrefix(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        int r = 0;
        while (l < a.length() && r < b.length()) {
            if (a.charAt(l) == b.charAt(r))
                sb.append(a.charAt(l));
            else
                return sb.toString();

            l++;
            r++;
        }

        return sb.toString();
    }
}