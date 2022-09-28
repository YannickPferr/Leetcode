package other.easy;

/**
 * Problem: 367. Valid Perfect Square
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsvalid-perfect-square
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;
        while (l < r) {
            long m = l + (r - l) / 2;
            if (m * m >= num)
                r = m;
            else
                l = m + 1;
        }
        return l * l == num ? true : false;
    }
}