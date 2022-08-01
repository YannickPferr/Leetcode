package other.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 47. Permutations II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspermutations-ii
 */
public class PermutationsII {
    List<List<Integer>> l = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), new boolean[nums.length]);
        return l;
    }

    public void backtracking(int[] nums, List<Integer> curr, boolean[] seen) {
        if (curr.size() == nums.length)
            l.add(new ArrayList<>(curr));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (seen[i] || (i - 1 >= 0 && nums[i] == nums[i - 1] && !seen[i - 1]))
                    continue;

                curr.add(nums[i]);
                seen[i] = true;
                backtracking(nums, curr, seen);
                curr.remove(curr.size() - 1);
                seen[i] = false;
            }
        }
    }
}