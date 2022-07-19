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

        int countDiffIdx = 0;
        int[] countS = new int[26];
        int[] countGoal = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countGoal[goal.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i))
                countDiffIdx++;
        }
        for (int i = 0; i < 26; i++)
            if (countS[i] != countGoal[i])
                return false;

        if (countDiffIdx > 2)
            return false;

        if (countDiffIdx == 2)
            return true;

        for (int i = 0; i < 26; i++) {
            if (countS[i] > 1)
                return true;
        }

        return false;
    }
}