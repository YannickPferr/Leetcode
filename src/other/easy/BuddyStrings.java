package other.easy;

/**
 * Problem: 859. Buddy Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsbuddy-strings
 */
public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        int countDiff = 0;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < goal.length(); i++) {
            char c1 = s.charAt(i);
            map1[c1 - 'a']++;
            char c2 = goal.charAt(i);
            map2[c2 - 'a']++;
            if (c1 != c2)
                countDiff++;
            if (countDiff > 2)
                return false;
        }

        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i])
                return false;
            if (countDiff == 0 && map1[i] > 1)
                countDiff = 2;
        }

        return countDiff == 2;
    }
}