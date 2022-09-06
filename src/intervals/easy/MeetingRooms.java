package intervals.easy;

import java.util.Arrays;

/**
 * Problem: 252. Meeting Rooms
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmeeting-rooms
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int lastEnd = 0;
        for (int[] interval : intervals) {
            if (interval[0] < lastEnd)
                return false;
            lastEnd = interval[1];
        }

        return true;
    }
}