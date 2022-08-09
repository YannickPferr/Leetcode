package bitmanipulation.medium;

/**
 * Problem: 7. Reverse Integer
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsreverse-integer
 */
public class ReverseInteger {
    public int reverse(int x) {
        long reversed = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            x /= 10;
            reversed = reversed * 10 + lastDigit;
        }

        if (reversed >= Integer.MAX_VALUE || reversed <= Integer.MIN_VALUE)
            return 0;
        return (int) reversed;
    }
}