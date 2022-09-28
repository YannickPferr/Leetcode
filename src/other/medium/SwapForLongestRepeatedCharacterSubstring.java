package other.medium;

/**
 * Problem: 1156. Swap For Longest Repeated Character Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsswap-for-longest-repeated-character-substring
 */
public class SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        int[] chars = new int[26];
        for (int i = 0; i < text.length(); i++)
            chars[text.charAt(i) - 'a']++;

        int max = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (chars[c - 'a'] == 0)
                continue;

            int lastDiff = -1;
            int start = 0;
            for (int i = 0; i < text.length(); i++) {
                max = Math.max(max, Math.min(chars[c - 'a'], i - start));
                if (text.charAt(i) != c) {
                    if (lastDiff != -1)
                        start = lastDiff + 1;
                    lastDiff = i;
                }
            }
            max = Math.max(max, Math.min(chars[c - 'a'], text.length() - start));
        }
        return max;
    }
}