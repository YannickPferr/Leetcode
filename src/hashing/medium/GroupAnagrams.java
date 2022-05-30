package hashing.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 49. Group Anagrams
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsgroup-anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            List<String> l = hm.getOrDefault(str, new ArrayList<>());
            l.add(s);
            hm.put(str, l);
        }

        ArrayList<List<String>> l = new ArrayList<>();
        for (String key : hm.keySet())
            l.add(hm.get(key));

        return l;
    }
}