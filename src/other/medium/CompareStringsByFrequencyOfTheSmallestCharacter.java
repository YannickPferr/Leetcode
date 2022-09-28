package other.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: 1170. Compare Strings by Frequency of the Smallest Character
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscompare-strings-by-frequency-of-the-smallest-character
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        List<Integer> wordScores = new ArrayList<>();
        for (String word : words)
            wordScores.add(f(word));
        Collections.sort(wordScores);

        int[] answer = new int[queries.length];
        int i = 0;
        for (String query : queries) {
            int score = f(query);
            int l = 0;
            int r = wordScores.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (wordScores.get(m) > score)
                    r = m;
                else
                    l = m + 1;
            }
            answer[i++] = wordScores.size() - l;
        }

        return answer;
    }

    public int f(String s) {
        char smallest = 'z';
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < smallest)
                smallest = c;
            freq[c - 'a']++;
        }
        return freq[smallest - 'a'];
    }
}