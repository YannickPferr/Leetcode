package other.easy;

/**
 * Problem: 344. Reverse String
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsreverse-string
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r)
            swap(s, l++, r--);
    }

    public void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}