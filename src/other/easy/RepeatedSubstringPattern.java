package other.easy;

/**
 * Problem: 459. Repeated Substring Pattern
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsrepeated-substring-pattern
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = s.length() / 2; i > 0; i--) {
            if (fits(s.substring(0, i), s))
                return true;
        }

        return false;
    }

    public boolean fits(String s1, String s2) {
        if (s2.length() % s1.length() != 0)
            return false;

        for (int i = 0; i < s2.length(); i++)
            if (s1.charAt(i % s1.length()) != s2.charAt(i))
                return false;

        return true;
    }
}