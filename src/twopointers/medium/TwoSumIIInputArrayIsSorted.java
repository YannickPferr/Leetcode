package twopointers.medium;

/**
 * Problem: 167. Two Sum II - Input Array Is Sorted
 * Difficulty: Medium
 * Link: https://leetcode.com/problemstwo-sum-ii-input-array-is-sorted
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target)
                return new int[]{l + 1, r + 1};
            else if (sum < target)
                l++;
            else
                r--;
        }

        return null;
    }
}