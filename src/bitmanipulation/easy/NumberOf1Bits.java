package bitmanipulation.easy;

/**
 * Problem: 191. Number of 1 Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsnumber-of-1-bits
 */
public public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = n;
        int count = 0;
        while (num != 0) {
            num &= num - 1;
            count++;
        }

        return count;
    }
}