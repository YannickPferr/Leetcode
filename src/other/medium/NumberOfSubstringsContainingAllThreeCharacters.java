package other.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 1358. Number of Substrings Containing All Three Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnumber-of-substrings-containing-all-three-characters
 */
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

public class NumberOfSubstringsContainingAllThreeCharacters {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        for (int x = 1; x <= 1000; x++)
            bs(customfunction, z, x);

        return list;
    }

    public void bs(CustomFunction customfunction, int z, int x) {
        int l = 1;
        int r = 1000;
        List<Integer> lis = new ArrayList<>();
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = customfunction.f(x, m);
            if (val == z) {
                lis.add(x);
                lis.add(m);
                list.add(lis);
                lis = new ArrayList<>();
                break;
            } else if (val < z)
                l = m + 1;
            else
                r = m - 1;
        }
    }
}