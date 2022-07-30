package bitmanipulation.easy;

/**
 * Problem: 191. Number of 1 Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsnumber-of-1-bits
 */
public public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int lastDigit = n & 1;
            count += (0 | lastDigit);
            n = n >> 1;
        }
        return count;
    }
}