package other.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 140. Word Break II
 * Difficulty: Hard
 * Link: https://leetcode.com/problemsword-break-ii
 */
public class WordBreakII {
    List<String> l = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        rec(s, 0, wordDict, new StringBuilder());
        return l;
    }

    public void rec(String s, int pos, List<String> dict, StringBuilder sb) {
        if (pos == s.length()) {
            String w = sb.toString();
            w = w.substring(0, w.length() - 1);
            l.add(w);
        } else {
            for (String word : dict) {
                if (!s.startsWith(word, pos))
                    continue;

                sb.append(word + " ");
                rec(s, pos + word.length(), dict, sb);
                sb.delete(sb.length() - (word.length() + 1), sb.length());
            }
        }
    }
}