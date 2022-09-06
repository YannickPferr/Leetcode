package other.easy;

/**
 * Problem: 1732. Find the Highest Altitude
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-the-highest-altitude
 */
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int runningSum = 0;
        for (int g : gain) {
            runningSum += g;
            max = Math.max(runningSum, max);
        }
        return max;
    }
}