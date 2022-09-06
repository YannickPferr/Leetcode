package other.medium;

/**
 * Problem: 1151. Minimum Swaps to Group All 1's Together
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-swaps-to-group-all-1s-together
 */
public class MinimumSwapsToGroupAll1STogether {
    public int minSwaps(int[] data) {
        int windowSize = 0;
        for (int num : data)
            if (num == 1)
                windowSize++;

        int start = 0;
        int currOnes = 0;
        for (int i = 0; i < windowSize; i++)
            if (data[i] == 1)
                currOnes++;

        int min = windowSize - currOnes;
        for (int i = windowSize; i < data.length; i++) {
            currOnes -= data[start];
            currOnes += data[i];
            start++;
            min = Math.min(windowSize - currOnes, min);
        }
        return min;
    }
}