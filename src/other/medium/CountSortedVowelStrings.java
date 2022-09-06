package other.medium;

import java.util.Arrays;

/**
 * Problem: 1641. Count Sorted Vowel Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscount-sorted-vowel-strings
 */
public class CountSortedVowelStrings {
    int[][] cache;

    public int countVowelStrings(int n) {
        cache = new int[n + 1][6];
        for (int[] row : cache)
            Arrays.fill(row, -1);
        return rec(n, 5);
    }

    public int rec(int n, int vowel) {
        if (n == 1)
            return vowel;
        if (cache[n][vowel] != -1)
            return cache[n][vowel];

        int count = 0;
        for (int i = 1; i <= vowel; i++)
            count += rec(n - 1, i);
        cache[n][vowel] = count;
        return count;
    }
}