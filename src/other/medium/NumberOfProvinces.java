package other.medium;

import java.util.HashSet;

/**
 * Problem: 547. Number of Provinces
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-provinces
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int groups = 0;
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (!seen.contains(i)) {
                dfs(isConnected, i, seen);
                groups++;
            }
        }

        return groups;
    }

    public void dfs(int[][] isConnected, int city, HashSet<Integer> seen) {
        seen.add(city);
        for (int i = 0; i < isConnected[city].length; i++) {
            if (isConnected[city][i] == 1 && !seen.contains(i))
                dfs(isConnected, i, seen);
        }
    }
}