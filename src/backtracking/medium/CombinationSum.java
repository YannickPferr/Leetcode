package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 39. Combination Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    List<List<Integer>> combs = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rec(candidates, 0, target, new ArrayList<>());
        return combs;
    }

    public void rec(int[] candidates, int start, int target, List<Integer> l) {
        if (target == 0)
            combs.add(new ArrayList<>(l));

        else
            for (int i = start; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (target - candidate >= 0) {
                    l.add(candidate);
                    rec(candidates, i, target - candidate, l);
                    l.remove(l.size() - 1);
                }
            }
    }
}
