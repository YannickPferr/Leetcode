package other.medium;

import java.util.Arrays;

/**
 * Problem: 1029. Two City Scheduling
 * Difficulty: Medium
 * Link: https://leetcode.com/problemstwo-city-scheduling
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int i = 0;
        for (int[] arr : costs)
            sum += arr[i++ < costs.length / 2 ? 0 : 1];
        return sum;
    }

    int min = Integer.MAX_VALUE;
    int[][] dp;

    //O(n2) -> not accepted
    public void dfs(int[][] costs, int pos, int sum, int countA, int countB) {
        if (pos >= costs.length)
            min = Math.min(min, sum);
        else {
            if (sum + costs[pos][0] < min && countA < costs.length / 2) {
                dfs(costs, pos + 1, sum + costs[pos][0], countA + 1, countB);
            }
            if (sum + costs[pos][1] < min && countB < costs.length / 2) {
                dfs(costs, pos + 1, sum + costs[pos][1], countA, countB + 1);
            }
        }
    }
}