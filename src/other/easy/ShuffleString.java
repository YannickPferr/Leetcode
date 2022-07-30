package other.easy;

/**
 * Problem: 1528. Shuffle String
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsshuffle-string
 */
public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] restored = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            restored[indices[i]] = s.charAt(i);
        return new String(restored);
    }
}