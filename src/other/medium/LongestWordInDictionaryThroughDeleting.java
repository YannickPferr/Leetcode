package other.medium;

import java.util.List;

/**
 * Problem: 524. Longest Word in Dictionary through Deleting
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslongest-word-in-dictionary-through-deleting
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> dictionary) {
        String output = "";
        for (String word : dictionary) {
            if (word.length() > s.length())
                continue;

            int j = 0;
            for (int i = 0; i < s.length() && j < word.length(); i++) {
                char a = s.charAt(i);
                char b = word.charAt(j);
                if (a == b)
                    j++;
            }

            if (j == word.length())
                output = word.length() > output.length() ? word : (word.length() == output.length() && word.compareTo(output) < 0 ? word : output);
        }
        return output;
    }
}
