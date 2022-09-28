package other.medium;

/**
 * Problem: 962. Maximum Width Ramp
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximum-width-ramp
 */
public class MaximumWidthRamp {
    public int minFlipsMonoIncr(String s) {
        int countOnes = 0;
        int countFlips = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1')
                countOnes++;
            else
                countFlips++;
            countFlips = Math.min(countOnes, countFlips);
        }
        return countFlips;
    }
}