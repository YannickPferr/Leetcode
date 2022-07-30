package other.easy;

import java.util.HashMap;

/**
 * Problem: 290. Word Pattern
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsword-pattern
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        int letter = 0;
        HashMap<String, Character> wordMap = new HashMap<>();
        HashMap<Character, String> charMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (letter >= pattern.length())
                return false;

            char c = s.charAt(i);
            char patternLetter = pattern.charAt(letter);
            if (c == ' ') {
                if (wordMap.containsKey(sb.toString()))
                    if (wordMap.get(sb.toString()) != patternLetter)
                        return false;
                if (charMap.containsKey(patternLetter))
                    if (!charMap.get(patternLetter).equals(sb.toString()))
                        return false;

                wordMap.put(sb.toString(), patternLetter);
                charMap.put(patternLetter, sb.toString());
                sb = new StringBuilder();
                letter++;
            } else {
                sb.append(c);
            }
        }

        char patternLetter = pattern.charAt(letter);
        if (wordMap.containsKey(sb.toString()))
            if (wordMap.get(sb.toString()) != patternLetter)
                return false;
        if (charMap.containsKey(patternLetter))
            if (!charMap.get(patternLetter).equals(sb.toString()))
                return false;

        return letter == pattern.length() - 1;
    }
}