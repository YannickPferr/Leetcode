package other.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 1291. Sequential Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssequential-digits
 */
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> l = new ArrayList<>();
        String s = "123456789";
        int minWindowLen = String.valueOf(low).length();
        int maxWindowLen = Math.min(String.valueOf(high).length(), s.length());
        for (int i = minWindowLen; i <= maxWindowLen; i++) {
            StringBuilder window = new StringBuilder();
            for (int j = 0; j < i; j++)
                window.append(s.charAt(j));
            int val = Integer.parseInt(window.toString());
            if (val >= low && val <= high)
                l.add(val);
            for (int j = i; j < s.length(); j++) {
                window.deleteCharAt(0);
                window.append(s.charAt(j));
                val = Integer.parseInt(window.toString());
                if (val >= low && val <= high)
                    l.add(val);
            }
        }
        return l;
    }
}