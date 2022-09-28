package other.medium;

import java.util.Arrays;

/**
 * Problem: 1552. Magnetic Force Between Two Balls
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmagnetic-force-between-two-balls
 */
public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = position[position.length - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (!isFeasible(position, mid, m))
                r = mid;
            else
                l = mid + 1;
        }
        return l - 1;
    }

    public boolean isFeasible(int[] position, int minForce, int balls) {
        int prevBall = position[0];
        balls--;
        for (int i = 1; i < position.length && balls > 0; i++) {
            int pos = position[i];
            if (pos - prevBall >= minForce) {
                prevBall = pos;
                balls--;
            }
        }
        return balls == 0;
    }
}