package hashing.easy;

import java.util.HashMap;

/**
 * Problem: 242. Valid Anagram
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-anagram
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
            count2.put(t.charAt(i), count2.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Character c : count.keySet()) {
            if (!count2.containsKey(c) || count2.get(c).intValue() != count.get(c).intValue())
                return false;
        }

        return true;
    }
}