package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Problem: 90. Subsets II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssubsets-ii
 */
public class SubsetsII {
    HashSet<List<Integer>> all = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        rec(nums, 0, new ArrayList<>());
        return new ArrayList<>(all);
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