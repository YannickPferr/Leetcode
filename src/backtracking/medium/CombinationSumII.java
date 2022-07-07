package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 40. Combination Sum II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscombination-sum-ii
 */
public class CombinationSumII {
    List<List<Integer>> all = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), candidates, 0, target);
        return all;
    }

    public void backtracking(List<Integer> current, int[] candidates, int pos, int target) {
        if (target == 0)
            all.add(new ArrayList<>(current));
        else if (target > 0) {
            for (int i = pos; i < candidates.length; i++) {
                if (i > pos && candidates[i] == candidates[i - 1])
                    continue;
                current.add(candidates[i]);
                backtracking(current, candidates, i + 1, target - candidates[i]);
                current.remove(current.size() - 1);
            }
        }
    }
}