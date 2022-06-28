package other.easy;

/**
 * Problem: 2124. Check if All A's Appears Before All B's
 * Difficulty: Easy
 * Link: https://leetcode.com/problemscheck-if-all-as-appears-before-all-bs
 */
public class CheckIfAllASAppearsBeforeAllBS {
    public boolean checkString(String s) {
        int start = 0;
        while (start < s.length() && s.charAt(start) != 'b')
            start++;

        for (int i = start + 1; i < s.length(); i++)
            if (s.charAt(i) == 'a')
                return false;

        return true;
    }
}