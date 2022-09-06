package intervals.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: 253. Meeting Rooms II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmeeting-rooms-ii
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek())
                minHeap.poll();
            minHeap.add(interval[1]);
        }
        return minHeap.size();
    }
}