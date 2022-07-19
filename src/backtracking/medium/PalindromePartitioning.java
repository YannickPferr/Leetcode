package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 131. Palindrome Partitioning
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspalindrome-partitioning
 */
public class PalindromePartitioning {
    List<List<String>> all = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, new ArrayList<>());
        return all;
    }

    public void backtracking(String s, int pos, List<String> current) {
        if (pos == s.length())
            all.add(new ArrayList<>(current));
        else {
            for (int i = pos; i < s.length(); i++) {
                String curr = s.substring(pos, i + 1);
                if (!isPalindrome(curr))
                    continue;

                current.add(curr);
                backtracking(s, i + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}