package other.medium;

import java.util.HashMap;

/**
 * Problem: 1423. Maximum Points You Can Obtain from Cards
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximum-points-you-can-obtain-from-cards
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> count = new HashMap<>();
        int max = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i >= minSize) {
                if (window.size() <= maxLetters) {
                    String substr = s.substring(start, i);
                    count.put(substr, count.getOrDefault(substr, 0) + 1);
                    max = Math.max(count.get(substr), max);
                }

                window.put(s.charAt(start), window.get(s.charAt(start)) - 1);
                if (window.get(s.charAt(start)) == 0)
                    window.remove(s.charAt(start));
                start++;
            }

            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        if (window.size() <= maxLetters) {
            String substr = s.substring(start);
            count.put(substr, count.getOrDefault(substr, 0) + 1);
            max = Math.max(count.get(substr), max);
        }

        return max;
    }
}