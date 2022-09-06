package other.easy;

/**
 * Problem: 9. Palindrome Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problemspalindrome-number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int reversed = 0;
        int num = x;
        while (num > 0) {
            int lastDigit = num % 10;
            reversed = reversed * 10 + lastDigit;
            num /= 10;
        }
        return reversed == x;
    }
}