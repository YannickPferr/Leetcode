package other.easy;

import java.util.HashSet;

/**
 * Problem: 219. Contains Duplicate II
 * Difficulty: Easy
 * Link: https://leetcode.com/problemscontains-duplicate-ii
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.size() == k + 1)
                window.remove(nums[i - k - 1]);
            if (window.contains(nums[i]))
                return true;
            window.add(nums[i]);
        }
        return false;
    }
}