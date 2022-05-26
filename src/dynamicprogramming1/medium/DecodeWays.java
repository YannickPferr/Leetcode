package dynamicprogramming1.medium;

/**
 * Problem: 91. Decode Ways
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/decode-ways
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            char c = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            boolean alone = c != '0';
            boolean together = prev == '1' || (prev == '2' && c <= '6');
            if (alone && together)
                dp[i] = dp[i - 1] + dp[i - 2];
            else if (alone)
                dp[i] = dp[i - 1];
            else if (together)
                dp[i] = dp[i - 2];
            else
                dp[i] = 0;

        }

        return dp[s.length()];
    }
}