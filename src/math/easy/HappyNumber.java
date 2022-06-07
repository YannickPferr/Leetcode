package math.easy;

import java.util.HashSet;

/**
 * Problem: 202. Happy Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problemshappy-number
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        int happy = n;
        while (!hs.contains(happy)) {
            hs.add(happy);
            happy = calc(happy);
            if (happy == 1)
                return true;
        }
        return false;
    }

    public int calc(int n) {
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sum += lastDigit * lastDigit;
            n /= 10;
        }
        return sum;
    }
}
