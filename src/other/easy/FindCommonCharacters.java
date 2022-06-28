package other.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 1002. Find Common Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-common-characters
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        HashMap<Character, HashMap<Integer, Integer>> hm = new HashMap<>();
        int i = 0;
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                HashMap<Integer, Integer> map = hm.getOrDefault(word.charAt(j), new HashMap<>());
                map.put(i, map.getOrDefault(i, 0) + 1);
                hm.put(word.charAt(j), map);
            }
            i++;
        }

        List<String> l = new ArrayList<>();
        for (char c : hm.keySet()) {
            HashMap<Integer, Integer> map = hm.get(c);
            if (map.size() == words.length) {
                int min = Integer.MAX_VALUE;
                for (int word : map.keySet())
                    min = Math.min(map.get(word), min);
                for (i = 0; i < min; i++)
                    l.add(String.valueOf(c));
            }

        }

        return l;
    }
}