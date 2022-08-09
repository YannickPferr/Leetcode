package other.easy;

import java.util.HashMap;

/**
 * Problem: 1460. Make Two Arrays Equal by Reversing Sub-arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmake-two-arrays-equal-by-reversing-sub-arrays
 */
public class MakeTwoArraysEqualByReversingSubArrays {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> set = new HashMap<>();
        int num = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            set.put(s.charAt(i), set.getOrDefault(s.charAt(i), 0) + 1);
            while (set.size() >= 3) {
                int count = set.get(s.charAt(start));
                count--;
                if (count > 0)
                    set.put(s.charAt(start), count);
                else
                    set.remove(s.charAt(start));
                start++;
            }
            num += start;
        }
        return num;
    }
}