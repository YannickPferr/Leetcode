package twopointers.easy;

/**
 * Problem: 125. Valid Palindrome
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (!isAlphanumeric(s.charAt(l))) {
                l++;
                continue;
            }
            if (!isAlphanumeric(s.charAt(r))) {
                r--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;

            l++;
            r--;
        }

        return true;
    }

    public boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
