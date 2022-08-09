package other.easy;

import java.util.HashMap;

/**
 * Problem: 1876. Substrings of Size Three with Distinct Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problemssubstrings-of-size-three-with-distinct-characters
 */
public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        HashMap<Character, Integer> chars = new HashMap<>();
        int nums = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            while (chars.containsKey(s.charAt(i)))
                chars.remove(s.charAt(l++));

            chars.put(s.charAt(i), i);
            if (chars.size() == 3) {
                nums++;
                chars.remove(s.charAt(l++));
            }
        }
        return nums;
    }
}