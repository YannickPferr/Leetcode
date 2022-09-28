package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * Problem: 1654. Minimum Jumps to Reach Home
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-jumps-to-reach-home
 */
public class MinimumJumpsToReachHome {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : forbidden)
            hs.add(num);

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        hs.add(0);
        int pathLen = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] arr = q.poll();
                int pos = arr[0];
                if (pos == x)
                    return pathLen;
                int prevBW = arr[1];

                if (!hs.contains(pos - b) && pos - b > 0 && prevBW == 0) {
                    q.add(new int[]{pos - b, 1});
                    hs.add(pos - b);
                }

                if (!hs.contains(pos + a) && pos + a <= 6000) {
                    q.add(new int[]{pos + a, 0});
                    hs.add(pos + a);
                }
            }
            pathLen++;
        }
        return -1;
    }
}