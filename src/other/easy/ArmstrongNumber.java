package other.easy;

/**
 * Problem: 1134. Armstrong Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsarmstrong-number
 */
public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        int k = String.valueOf(n).length();
        int x = n;
        long sum = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            x /= 10;
            sum += Math.pow(lastDigit, k);
        }
        return sum == n;
    }
}