package other.easy;

/**
 * Problem: 796. Rotate String
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsrotate-string
 */
public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        int l = 0;
        int r = 0;
        int i = 0;
        while (l < s.length() && r < goal.length()) {
            int rIdx = (r + i) % goal.length();
            if (s.charAt(l) == goal.charAt(rIdx)) {
                l++;
                i++;
            } else {
                l = 0;
                i = 0;
                r++;
            }
        }

        return r < l;
    }
}