package dynamicprogramming1.medium;

/**
 * Problem: 647. Palindromic Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspalindromic-substrings
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i - 1, i + 1);
            if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i))
                count += expandAroundCenter(s, i - 2, i + 1);
            ;
        }
        return count;
    }

    public int expandAroundCenter(String s, int left, int right) {
        int count = 1;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++))
            count++;
        return count;
    }
}