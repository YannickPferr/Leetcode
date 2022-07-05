package dynamicprogramming1.medium;

/**
 * Problem: 5. Longest Palindromic Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslongest-palindromic-substring
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, 1, i - 1, i + 1);

            if (len1 > (end - start)) {
                start = i - (len1 - 1) / 2;
                end = i + len1 / 2 + 1;
            }

            if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i)) {
                int len2 = expandAroundCenter(s, 2, i - 2, i + 1);
                if (len2 > (end - start)) {
                    start = i - len2 / 2;
                    end = i + len2 / 2;
                }
            }
        }
        return s.substring(start, end);
    }

    public int expandAroundCenter(String s, int len, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++))
            len += 2;

        return len;
    }
}