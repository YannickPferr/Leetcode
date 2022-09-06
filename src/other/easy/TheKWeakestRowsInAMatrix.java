package other.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: 1337. The K Weakest Rows in a Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsthe-k-weakest-rows-in-a-matrix
 */
public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, List<Integer>> count = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int soldiers = numSoldiers(row);
            List<Integer> idxes = count.getOrDefault(soldiers, new ArrayList<>());
            idxes.add(i);
            count.put(soldiers, idxes);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int soldiers : count.keySet())
            for (int idx : count.get(soldiers))
                minHeap.add(new int[]{soldiers, idx});

        int[] weakest = new int[k];
        for (int i = 0; i < k; i++)
            weakest[i] = minHeap.poll()[1];
        return weakest;
    }

    public int numSoldiers(int[] row) {
        int idx = -1;
        int l = 0;
        int r = row.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (row[mid] == 1) {
                idx = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return idx + 1;
    }
}