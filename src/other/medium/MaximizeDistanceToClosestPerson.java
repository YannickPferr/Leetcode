package other.medium;

/**
 * Problem: 849. Maximize Distance to Closest Person
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximize-distance-to-closest-person
 */
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int curr = 0;
        boolean first = true;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                int dist = 0;
                if (first) {
                    dist = curr;
                    first = false;
                } else
                    dist = (curr + 1) / 2;
                max = Math.max(max, dist);
                curr = 0;
            } else
                curr++;
        }
        return Math.max(max, curr);
    }
}