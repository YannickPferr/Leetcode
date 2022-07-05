package dynamicprogramming1.medium;

import java.util.List;

/**
 * Problem: 139. Word Break
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsword-break
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (canReach(s, i, wordDict, dp))
                dp[i] = true;
        }
        return dp[0];
    }

    public boolean canReach(String s, int pos, List<String> dict, boolean[] dp) {
        for (String word : dict)
            if (pos + word.length() <= s.length() && word.equals(s.substring(pos, pos + word.length())))
                if (dp[pos + word.length()])
                    return true;
        return false;
    }
}