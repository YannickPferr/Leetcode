package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 17. Letter Combinations of a Phone Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsletter-combinations-of-a-phone-number
 */
public class LetterCombinationsOfAPhoneNumber {
    List<String> l = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return l;

        backtracking(digits, 0, new StringBuilder());
        return l;
    }

    public void backtracking(String digits, int pos, StringBuilder current) {
        if (current.length() == digits.length())
            l.add(current.toString());
        else {
            for (String letter : getLetters(digits.charAt(pos))) {
                current.append(letter);
                backtracking(digits, pos + 1, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    public List<String> getLetters(char c) {
        switch (c) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");
            case '5':
                return Arrays.asList("j", "k", "l");
            case '6':
                return Arrays.asList("m", "n", "o");
            case '7':
                return Arrays.asList("p", "q", "r", "s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y", "z");
            default:
                return new ArrayList<>();
        }
    }
}