package other.easy;

/**
 * Problem: 461. Hamming Distance
 * Difficulty: Easy
 * Link: https://leetcode.com/problemshamming-distance
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int h = x ^ y;
        int count = 0;
        while (h > 0) {
            count += h & 1;
            h >>= 1;
        }
        return count;
    }
}