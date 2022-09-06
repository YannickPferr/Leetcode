package other.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 926. Flip String to Monotone Increasing
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsflip-string-to-monotone-increasing
 */
public class FlipStringToMonotoneIncreasing {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> l = new ArrayList<>();
        loop:
        for (String word : words) {
            HashMap<Character, Character> map = new HashMap<>();
            HashMap<Character, Character> map2 = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                if (map.containsKey(pattern.charAt(i))) {
                    if (word.charAt(i) != map.get(pattern.charAt(i)).charValue())
                        continue loop;
                } else if (map2.containsKey(word.charAt(i))) {
                    if (pattern.charAt(i) != map2.get(word.charAt(i)).charValue())
                        continue loop;
                } else {
                    map.put(pattern.charAt(i), word.charAt(i));
                    map2.put(word.charAt(i), pattern.charAt(i));
                }
            }
            l.add(word);
        }
        return l;
    }
}