package backtracking.medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Problem: 46. Permutations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/permutations
 */
public class Permutations {
    List<List<Integer>> perms = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        rec(nums, new LinkedHashSet<>());
        return perms;
    }

    public void rec(int[] nums, LinkedHashSet<Integer> l) {
        if (l.size() == nums.length)
            perms.add(new ArrayList<>(l));
        else
            for (int num : nums) {
                if (l.contains(num))
                    continue;

                l.add(num);
                rec(nums, l);
                l.remove(num);
            }
    }
}