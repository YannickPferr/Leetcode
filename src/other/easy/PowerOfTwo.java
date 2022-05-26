package other.easy;

/**
 * Problem: 231. Power of Two
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/power-of-two
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;

        int l = 0;
        int r = 32;
        while (l < r) {
            int m = l + (r - l) / 2;
            long pow = (long) Math.pow(2, m);
            if (pow == n)
                return true;
            else if (pow > n)
                r = m - 1;
            else
                l = m + 1;
        }

        return Math.pow(2, l) == n;
    }
}