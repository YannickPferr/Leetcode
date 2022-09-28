package other.medium;

import java.util.Arrays;

/**
 * Problem: 646. Maximum Length of Pair Chain
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximum-length-of-pair-chain
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int min = pairs[0][1];
        int minIndex = 0;
        int count = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > min) {
                min = pairs[i][1];
                count++;
            }
        }
        return count;
    }
}