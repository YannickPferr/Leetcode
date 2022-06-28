package other.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 229. Majority Element II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmajority-element-ii
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);

        List<Integer> l = new ArrayList<>();
        for (Integer i : count.keySet()) {
            int amount = count.get(i);
            if (amount > nums.length / 3)
                l.add(i);
        }

        return l;
    }
}