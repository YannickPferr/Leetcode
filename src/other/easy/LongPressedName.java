package other.easy;

/**
 * Problem: 925. Long Pressed Name
 * Difficulty: Easy
 * Link: https://leetcode.com/problemslong-pressed-name
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int l = 0;
        int r = 0;
        Character last = null;
        while (l < name.length() && r < typed.length()) {
            char c = name.charAt(l);
            if (last != null && c != last.charValue() && typed.charAt(r) == last)
                r++;
            else {
                if (c != typed.charAt(r))
                    return false;
                last = c;
                l++;
                r++;
            }
        }
        while (r < typed.length())
            if (typed.charAt(r++) != last)
                return false;
        return l == name.length() && r == typed.length();
    }
}