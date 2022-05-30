package other.medium;

/**
 * Problem: 788. Rotated Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsrotated-digits
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++)
            if (isValid(i))
                count++;
        return count;
    }

    public boolean isValid(int num) {
        int count = 0;
        while (num > 0) {
            int r = num % 10;
            if (r == 3 || r == 4 || r == 7)
                return false;
            if (r == 2 || r == 5 || r == 6 || r == 9)
                count++;
            num = num / 10;
        }
        return count > 0;
    }
}