package other.medium;

import java.util.HashMap;

/**
 * Problem: 740. Delete and Earn
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdelete-and-earn
 */
public class DeleteAndEarn {
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            max = Math.max(max, num);
        }

        return rec(count, max);
    }

    public int rec(HashMap<Integer, Integer> count, int max) {
        if (max == 0)
            return 0;
        if (max == 1)
            return count.getOrDefault(max, 0) * max;
        if (cache.get(max) != null)
            return cache.get(max);
        cache.put(max, Math.max(count.getOrDefault(max, 0) * max + rec(count, max - 2), rec(count, max - 1)));
        return cache.get(max);
    }
}