package math.medium;

/**
 * Problem: 50. Pow(x, n)
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspowx-n
 */
public class PowXN {
    public double myPow(double x, int n) {
        double curr = 1;
        for (int i = 0; i < Math.abs(n); i++)
            curr *= x;
        if (n < 0)
            return 1 / curr;
        return curr;
    }
}