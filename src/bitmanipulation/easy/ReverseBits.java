package bitmanipulation.easy;

/**
 * Problem: 190. Reverse Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsreverse-bits
 */
public public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int newN = 0;
        for (int i = 0; i < 32; i++) {
            newN = (newN << 1) | (n & 1);
            n = n >> 1;
        }
        return newN;
    }
}