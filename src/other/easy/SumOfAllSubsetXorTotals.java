package other.easy;

/**
 * Problem: 1863. Sum of All Subset XOR Totals
 * Difficulty: Easy
 * Link: https://leetcode.com/problemssum-of-all-subset-xor-totals
 */
public class SumOfAllSubsetXorTotals {

    public int subsetXORSum(int[] nums) {
        return rec(nums, 0, 0);
    }

    public int rec(int[] nums, int start, int xor) {
        int sum = xor;
        for (int i = start; i < nums.length; i++)
            sum += rec(nums, i + 1, xor ^ nums[i]);

        return sum;
    }
}