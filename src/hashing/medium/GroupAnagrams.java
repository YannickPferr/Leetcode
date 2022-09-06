package hashing.medium;

import java.util.ArrayList;
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
        for (String word : strs) {
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i++)
                count[word.charAt(i) - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < count[i]; j++)
                    sb.append((char) (i + 'a'));

            List<String> membersOfGroup = hm.getOrDefault(sb.toString(), new ArrayList<>());
            membersOfGroup.add(word);
            hm.put(sb.toString(), membersOfGroup);
        }

        List<List<String>> l = new ArrayList<>();
        for (List<String> group : hm.values())
            l.add(group);
        return l;
    }
}