package other.easy;

import java.util.HashMap;

/**
 * Problem: 169. Majority Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/majority-element
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i : count.keySet())
            if (count.get(i) > nums.length / 2)
                return i;

        return 0;
    }
}