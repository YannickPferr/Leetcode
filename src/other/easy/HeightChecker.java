package other.easy;

/**
 * Problem: 1051. Height Checker
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsheight-checker
 */
public class HeightChecker {
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

