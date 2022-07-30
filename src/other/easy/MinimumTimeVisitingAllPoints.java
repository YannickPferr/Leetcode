package other.easy;

/**
 * Problem: 1266. Minimum Time Visiting All Points
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsminimum-time-visiting-all-points
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int total = 0;
        for (int i = 1; i < points.length; i++)
            total += minTravelTime(points[i - 1], points[i]);
        return total;
    }

    public int minTravelTime(int[] start, int[] end) {
        int xStart = start[0];
        int yStart = start[1];

        int xEnd = end[0];
        int yEnd = end[1];

        int time = 0;
        while (xStart != xEnd || yStart != yEnd) {
            if (xStart < xEnd)
                xStart++;
            else if (xStart > xEnd)
                xStart--;

            if (yStart < yEnd)
                yStart++;
            else if (yStart > yEnd)
                yStart--;

            time++;
        }
        return time;
    }
}