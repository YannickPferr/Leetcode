package other.easy;

/**
 * Problem: 69. Sqrt(x)
 * Difficulty: Easy
 * Link: https://leetcode.com/problemssqrtx
 */
public class Sqrtx {
    public int mySqrt(int x) {

        long l = 0;
        long r = x;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid < x)
                l = mid + 1;
            else
                r = mid - 1;
        }

        if (l * l > x)
            return (int) l - 1;

        return (int) l;
    }
}