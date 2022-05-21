package greedy.medium;

/**
 * Problem: 134. Gas Station
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/gas-station/
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int curr = 0;
        int currIdx = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            curr += diff;

            if (curr < 0) {
                curr = 0;
                currIdx = i + 1;
            }
        }

        if (total < 0)
            return -1;
        else
            return currIdx;
    }
}
