package other.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 696. Count Binary Substrings
 * Difficulty: Easy
 * Link: https://leetcode.com/problemscount-binary-substrings
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        List<Integer> groups = new ArrayList<>();
        int count = 1;
        int total = 0;
        int group = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else {
                groups.add(count);
                if (group - 1 >= 0)
                    total += Math.min(count, groups.get(group - 1));
                group++;
                count = 1;
            }
        }
        groups.add(count);
        if (group - 1 >= 0)
            total += Math.min(count, groups.get(group - 1));

        return total;
    }
}