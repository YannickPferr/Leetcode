package other.easy;

/**
 * Problem: 9. Palindrome Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/palindrome-number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        return isPalindromeI(x);
    }

    public boolean isPalindromeI(int x) {
        if (x < 0)
            return false;

        int copy = x;
        int reverted = 0;
        while (copy > 0) {
            reverted = reverted * 10 + copy % 10;
            copy /= 10;
        }

        return reverted == x;
    }

    public boolean isPalindromeS(int x) {
        if (x < 0)
            return false;

        String str = String.valueOf(x);
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }
}