package linkedlist.easy;

import java.util.HashMap;

/**
 * Problem: 21. Merge Two Sorted Lists
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            count.put(s1.charAt(i), count.getOrDefault(s1.charAt(i), 0) + 1);
            count2.put(s2.charAt(i), count2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (valid(count, count2))
                return true;

            char c = s2.charAt(i);
            count2.put(c, count2.getOrDefault(c, 0) + 1);
            count2.put(s2.charAt(i - s1.length()), count2.get(s2.charAt(i - s1.length())) - 1);
        }

        return valid(count, count2);
    }

    public boolean valid(HashMap<Character, Integer> count, HashMap<Character, Integer> count2) {
        for (char c : count.keySet())
            if (count2.getOrDefault(c, -1).intValue() != count.get(c).intValue())
                return false;

        return true;
    }
}
