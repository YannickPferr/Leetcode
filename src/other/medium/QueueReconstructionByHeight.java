package other.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: 406. Queue Reconstruction by Height
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsqueue-reconstruction-by-height
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> l = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            int idx = person[1];
            l.add(idx, person);
        }

        return l.toArray(new int[people.length][2]);
    }
}