package other.medium;

/**
 * Problem: 28. Find the Index of the First Occurrence in a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-the-index-of-the-first-occurrence-in-a-string
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (needle.length() > haystack.length())
            return -1;

        int idx = -1;
        int l = 0;
        int r = 0;
        while (l < haystack.length()) {
            char a = haystack.charAt(l);
            char b = needle.charAt(r);
            if (a == b) {
                if (r == 0)
                    idx = l;
                if (r == needle.length() - 1)
                    return idx;

                l++;
                r++;
            } else {
                if (idx == -1)
                    l++;
                else
                    l = idx + 1;
                idx = -1;
                r = 0;
            }
        }

        return -1;
    }
}