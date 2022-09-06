package slidingwindow.hard;

import java.util.HashMap;

/**
 * Problem: 76. Minimum Window Substring
 * Difficulty: Hard
 * Link: https://leetcode.com/problemsminimum-window-substring
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        HashMap<Character, Integer> window = new HashMap<>();
        int bestStart = 0;
        int bestEnd = s.length();
        int l = 0;
        boolean validOnce = false;
        int valid = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i)) && window.getOrDefault(s.charAt(i), 0) < count.get(s.charAt(i)) && window.getOrDefault(s.charAt(i), 0) + 1 == count.get(s.charAt(i)))
                valid++;
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);
            while (valid == count.size()) {
                validOnce = true;
                if (i + 1 - l < bestEnd - bestStart) {
                    bestStart = l;
                    bestEnd = i + 1;
                }
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if (count.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < count.get(s.charAt(l)))
                    valid--;
                if (window.get(s.charAt(l)) <= 0)
                    window.remove(s.charAt(l));
                l++;
            }
        }
        if (!validOnce)
            return "";
        return s.substring(bestStart, bestEnd);
    }
}