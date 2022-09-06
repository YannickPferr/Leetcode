package other.medium;

import java.util.Arrays;

/**
 * Problem: 2268. Minimum Number of Keypresses
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-number-of-keypresses
 */
public class MinimumNumberOfKeypresses {
    public int minimumKeypresses(String s) {
        Integer[] count = new Integer[26];
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;

        Arrays.sort(count, (a, b) -> b - a);
        int num = 0;
        for (int i = 0; i < 26; i++)
            num += count[i] * ((i + 9) / 9);
        return num;
    }
}
