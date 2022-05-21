package slidingwindow.medium;

import java.util.HashMap;

/**
 * Problem: 3. Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestRepeatingCharacterReplacement {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int l = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (window.containsKey(s.charAt(i)))
                l = Math.max(l, window.get(s.charAt(i)) + 1);

            window.put(s.charAt(i), i);
            max = Math.max(max, i + 1 - l);
        }

        return max;
    }
}
