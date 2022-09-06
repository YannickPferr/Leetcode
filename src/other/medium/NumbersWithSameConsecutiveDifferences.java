package other.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 967. Numbers With Same Consecutive Differences
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnumbers-with-same-consecutive-differences
 */
public class NumbersWithSameConsecutiveDifferences {
    List<String> l = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i < 10; i++)
            rec(i, n, k, new StringBuilder());
        int[] arr = new int[l.size()];
        int i = 0;
        for (String num : l)
            arr[i++] = Integer.parseInt(num);
        return arr;
    }

    public void rec(int num, int n, int k, StringBuilder sb) {
        if (num >= 10 || num < 0)
            return;

        sb.append(num);
        if (sb.length() == n)
            l.add(sb.toString());
        else {
            rec(num - k, n, k, sb);
            if (k > 0)
                rec(num + k, n, k, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}