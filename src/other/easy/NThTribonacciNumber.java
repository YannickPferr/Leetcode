package other.easy;

/**
 * Problem: 1137. N-th Tribonacci Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsn-th-tribonacci-number
 */
public class NThTribonacciNumber {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int height : heights)
            count[height]++;

        int res = 0;
        int currHeight = 1;
        for (int i = 0; i < heights.length; i++) {
            while (count[currHeight] == 0)
                currHeight++;

            if (heights[i] != currHeight)
                res++;

            count[currHeight]--;
        }
        return res;
    }
}

