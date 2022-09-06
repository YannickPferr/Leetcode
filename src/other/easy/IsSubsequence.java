package other.easy;

/**
 * Problem: 392. Is Subsequence
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsis-subsequence
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int l = 0;
        for (int i = 0; i < t.length(); i++)
            if (t.charAt(i) == s.charAt(l))
                if (l++ == s.length() - 1)
                    return true;
        return false;
    }
}