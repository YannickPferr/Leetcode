package other.medium;

import java.util.PriorityQueue;

/**
 * Problem: 1615. Maximal Network Rank
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximal-network-rank
 */
public class MaximalNetworkRank {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int k = 0;
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        for (int i = 0; i < n; i++)
            minHeap.add(new long[]{i, nums[i]});

        long sum = 0;
        for (int i = 0; i < right; i++) {
            long[] curr = minHeap.poll();
            if (i >= left - 1)
                sum += curr[1];
            if (curr[0] + 1 < n) {
                curr[0]++;
                curr[1] += nums[(int) curr[0]];
                minHeap.add(curr);
            }
        }
        return (int) (sum % (int) (Math.pow(10, 9) + 7));
    }
}
