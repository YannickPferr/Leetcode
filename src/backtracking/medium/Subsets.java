package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 78. Subsets
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssubsets
 */
public class Subsets {
    List<List<Integer>> all = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        rec(nums, 0, new ArrayList<>());
        return all;
    }

    public void rec(int[] nums, int start, List<Integer> l) {
        all.add(new ArrayList<>(l));
        for (int i = start; i < nums.length; i++) {
            l.add(nums[i]);
            rec(nums, i + 1, l);
            l.remove(l.size() - 1);
        }
    }
}