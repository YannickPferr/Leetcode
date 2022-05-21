package slidingwindow.medium;

import java.util.HashMap;

/**
 * Problem: 424. Longest Repeating Character Replacement
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int curr = 0;
        int max = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (!windowValid(count, k)) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
                curr--;
            }

            curr++;
            max = Math.max(max, curr);
        }

        return max;
    }

    public boolean windowValid(HashMap<Character, Integer> count, int k) {
        int size = 0;
        int maxChar = 0;
        for (char c : count.keySet()) {
            size += count.get(c);
            maxChar = Math.max(maxChar, count.get(c));
        }

        if (size - maxChar <= k)
            return true;

        return false;
    }

}
