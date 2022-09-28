package other.medium;

/**
 * Problem: 633. Sum of Square Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssum-of-square-numbers
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            long l = i;
            long r = (long) Math.sqrt(c);
            while (l <= r) {
                long m = l + (r - l) / 2;
                long squaredSum = i * i + m * m;
                if (squaredSum == c)
                    return true;
                else if (squaredSum > c)
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return false;
    }
}