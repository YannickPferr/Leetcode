package other.medium;

import java.util.TreeMap;

/**
 * Problem: 1094. Car Pooling
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscar-pooling
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> entriesAndExits = new TreeMap<>();
        for (int[] trip : trips) {
            entriesAndExits.put(trip[1], entriesAndExits.getOrDefault(trip[1], 0) + trip[0]);
            entriesAndExits.put(trip[2], entriesAndExits.getOrDefault(trip[2], 0) - trip[0]);
        }

        int occupied = 0;
        for (int change : entriesAndExits.values()) {
            occupied += change;
            if (occupied > capacity)
                return false;
        }

        return true;
    }
}