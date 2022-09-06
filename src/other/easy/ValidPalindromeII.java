package other.easy;

/**
 * Problem: 680. Valid Palindrome II
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsvalid-palindrome-ii
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return checkPalindrome(s, l + 1, r) || checkPalindrome(s, l, r - 1);
            l++;
            r--;
        }
        return true;
    }

    public boolean checkPalindrome(String s, int start, int end) {
        int l = start;
        int r = end;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}