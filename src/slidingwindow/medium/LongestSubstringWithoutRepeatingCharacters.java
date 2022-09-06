package slidingwindow.medium;

import java.util.HashSet;

/**
 * Problem: 3. Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslongest-substring-without-repeating-characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> window = new HashSet<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            max = Math.max(max, window.size());
            while (window.contains(c)) {
                window.remove(s.charAt(start));
                start++;
            }
            window.add(c);
        }
        return Math.max(max, window.size());
    }
}