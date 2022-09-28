package other.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 729. My Calendar I
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmy-calendar-i
 */
class MyCalendar {

    List<int[]> calendar = new ArrayList<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        int[] entry = new int[]{start, end};
        int startPos = findLeftOverlap(entry);
        int endPos = findRightOverlap(entry);
        if (startPos == endPos) {
            calendar.add(startPos, entry);
            return true;
        }

        return false;
    }

    public int findLeftOverlap(int[] entry) {
        int l = 0;
        int r = calendar.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (overlaps(calendar.get(m), entry))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public int findRightOverlap(int[] entry) {
        int l = 0;
        int r = calendar.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (!overlaps(entry, calendar.get(m)))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public boolean overlaps(int[] left, int[] right) {
        return right[0] < left[1];
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */