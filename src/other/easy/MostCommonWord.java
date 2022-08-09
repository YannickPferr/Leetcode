package other.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Problem: 819. Most Common Word
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmost-common-word
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>();
        for (String bannedWord : banned)
            bannedSet.add(bannedWord);

        HashMap<String, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (isPunctuationChar(c)) {
                if (sb.length() == 0)
                    continue;

                String word = sb.toString();
                if (!bannedSet.contains(word))
                    hm.put(word, hm.getOrDefault(word, 0) + 1);
                sb = new StringBuilder();
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        if (sb.length() > 0) {
            String word = sb.toString();
            if (!bannedSet.contains(word))
                hm.put(word, hm.getOrDefault(word, 0) + 1);
            sb = new StringBuilder();
        }

        int max = 0;
        String maxWord = "";
        for (String word : hm.keySet()) {
            int count = hm.get(word);
            if (count > max) {
                max = count;
                maxWord = word;
            }
        }

        return maxWord;
    }

    public boolean isPunctuationChar(char c) {
        switch (c) {
            case ' ':
            case '!':
            case '?':
            case '\'':
            case ',':
            case ';':
            case '.':
                return true;
            default:
                return false;
        }
    }
}