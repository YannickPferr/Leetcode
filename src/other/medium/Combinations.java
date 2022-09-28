package other.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: 77. Combinations
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscombinations
 */
public class Combinations {
    List<List<Integer>> all = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1, new LinkedList<>());
        return all;
    }

    public void backtracking(int n, int k, int pos, List<Integer> l) {
        if (k == 0) {
            all.add(new ArrayList<>(l));
            return;
        }

        //n - k + 1 because otherwise you know upfront, that you cannot find a combination
        //of length k, because the numbers would be out of range 
        //(e.g. n = 4, k = 2 -> you don't need to check if you can have 4 at position 0, because there are no numbers left)
        for (int i = pos; i <= n - k + 1; i++) {
            l.add(i);
            backtracking(n, k - 1, i + 1, l);
            l.remove(l.size() - 1);
        }
    }
}