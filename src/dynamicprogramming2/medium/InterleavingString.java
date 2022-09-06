package dynamicprogramming2.medium;

/**
 * Problem: 97. Interleaving String
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsinterleaving-string
 */
public class InterleavingString {
    Boolean[][] cache;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;

        cache = new Boolean[s1.length() + 1][s2.length() + 1];
        return rec(s1, s2, s3, 0, 0);
    }

    public boolean rec(String s1, String s2, String s3, int l, int r) {
        if (l + r >= s3.length())
            return true;
        if (cache[l][r] != null)
            return cache[l][r];

        boolean a = false;
        if (l < s1.length() && s1.charAt(l) == s3.charAt(l + r))
            a = rec(s1, s2, s3, l + 1, r);
        boolean b = false;
        if (r < s2.length() && s2.charAt(r) == s3.charAt(l + r))
            b = rec(s1, s2, s3, l, r + 1);
        cache[l][r] = a || b;
        return cache[l][r];
    }
}