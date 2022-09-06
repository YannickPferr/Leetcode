package other.easy;

/**
 * Problem: 58. Length of Last Word
 * Difficulty: Easy
 * Link: https://leetcode.com/problemslength-of-last-word
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (len > 0)
                    return len;
            } else
                len++;
        }
        return len;
    }
}