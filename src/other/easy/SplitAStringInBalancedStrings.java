package other.easy;

/**
 * Problem: 1221. Split a String in Balanced Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problemssplit-a-string-in-balanced-strings
 */
public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int countR = 0;
        int countL = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L')
                countL++;
            else
                countR++;

            if (countL > 0 && countR > 0 && countL == countR) {
                count++;
                countL = 0;
                countR = 0;
            }
        }
        return count;
    }
}