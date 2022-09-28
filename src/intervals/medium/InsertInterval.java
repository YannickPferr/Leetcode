package intervals.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 57. Insert Interval
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsinsert-interval
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = findOverlappingLeft(intervals, newInterval);
        int end = findOverlappingRight(intervals, newInterval);
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i <= start; i++)
            l.add(intervals[i]);
        int[] merged = start == end ? newInterval : mergeIntervals(intervals, newInterval, start + 1, end);
        l.add(merged);
        for (int i = end + 1; i < intervals.length; i++)
            l.add(intervals[i]);
        return l.toArray(new int[l.size()][2]);
    }

    public int[] mergeIntervals(int[][] intervals, int[] newInterval, int start, int end) {
        return new int[]{Math.min(newInterval[0], intervals[start][0]), Math.max(newInterval[1], intervals[end][1])};
    }

    public int findOverlappingLeft(int[][] intervals, int[] newInterval) {
        int l = 0;
        int r = intervals.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (overlaps(intervals[m], newInterval))
                r = m;
            else
                l = m + 1;
        }
        return l - 1;
    }

    public int findOverlappingRight(int[][] intervals, int[] newInterval) {
        int l = 0;
        int r = intervals.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (!overlaps(newInterval, intervals[m]))
                r = m;
            else
                l = m + 1;
        }
        return l - 1;
    }

    public boolean overlaps(int[] left, int[] right) {
        return left[1] >= right[0];
    }
}