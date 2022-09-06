package intervals.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem: 56. Merge Intervals
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmerge-intervals
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] merged = intervals[i];
            if (!stack.isEmpty() && merged[0] <= stack.peek()[1])
                merged = mergeIntervals(stack.pop(), merged);
            stack.push(merged);
        }

        int[][] outArr = new int[stack.size()][2];
        for (int i = outArr.length - 1; i >= 0; i--)
            outArr[i] = stack.pop();
        return outArr;
    }

    public int[] mergeIntervals(int[] a, int[] b) {
        return new int[]{a[0], Math.max(a[1], b[1])};
    }
}

