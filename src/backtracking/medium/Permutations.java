package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 46. Permutations
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspermutations
 */
public class Permutations {
    List<List<Integer>> l = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, new boolean[nums.length], new ArrayList<>());
        return l;
    }

    public void backtracking(int[] nums, boolean[] visited, List<Integer> curr) {
        if (curr.size() == nums.length)
            l.add(new ArrayList<>(curr));
        else
            for (int i = 0; i < nums.length; i++) {
                if (visited[i])
                    continue;

                curr.add(nums[i]);
                visited[i] = true;
                backtracking(nums, visited, curr);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
    }
}