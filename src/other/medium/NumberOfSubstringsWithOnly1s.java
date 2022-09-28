package other.medium;

/**
 * Problem: 1513. Number of Substrings With Only 1s
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnumber-of-substrings-with-only-1s
 */
public class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        long numSubstrings = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                long n = i - start;
                numSubstrings += n * (n + 1) / 2;
                start = i + 1;
            }
        }
        long n = s.length() - start;
        numSubstrings += n * (n + 1) / 2;
        return (int) (numSubstrings % (int) (Math.pow(10, 9) + 7));
    }
}