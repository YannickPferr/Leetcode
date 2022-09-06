package greedy.medium;

/**
 * Problem: 134. Gas Station
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsgas-station
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int currSum = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalSum += diff;
            currSum += diff;

            if (currSum < 0) {
                currSum = 0;
                idx = i + 1;
            }
        }

        return totalSum < 0 ? -1 : idx;
    }

}