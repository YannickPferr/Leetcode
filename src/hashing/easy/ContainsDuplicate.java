package hashing.easy;

import java.util.HashSet;

/**
 * Problem: 217. Contains Duplicate
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/contains-duplicate
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> count = new HashSet<>();
        for (int num : nums) {
            if (count.contains(num))
                return true;
            count.add(num);
        }

        return false;
    }
}