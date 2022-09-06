package other.medium;

import java.util.Arrays;

/**
 * Problem: 2222. Number of Ways to Select Buildings
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnumber-of-ways-to-select-buildings
 */
public class NumberOfWaysToSelectBuildings {
    long[][][] cache;

    public long numberOfWays(String s) {
        cache = new long[s.length()][3][3];
        for (long[][] l : cache)
            for (long[] l2 : l)
                Arrays.fill(l2, -1);
        return rec(s, 0, 0, 0);
    }

    public long rec(String s, int pos, int prev, int choices) {
        if (choices == 3)
            return 1;
        if (pos == s.length())
            return 0;
        if (cache[pos][prev][choices] != -1)
            return cache[pos][prev][choices];

        char c = s.charAt(pos);
        char prevChar = prev == 1 ? '0' : '1';
        long a = rec(s, pos + 1, prev, choices);
        long b = prev == 0 || c != prevChar ? rec(s, pos + 1, c == '0' ? 1 : 2, choices + 1) : 0;
        cache[pos][prev][choices] = a + b;
        return cache[pos][prev][choices];
    }
}