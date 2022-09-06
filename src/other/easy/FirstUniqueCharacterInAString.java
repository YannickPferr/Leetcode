package other.easy;

/**
 * Problem: 387. First Unique Character in a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfirst-unique-character-in-a-string
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}