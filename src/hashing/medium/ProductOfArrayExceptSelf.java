package hashing.medium;

/**
 * Problem: 238. Product of Array Except Self
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsproduct-of-array-except-self
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        out[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            out[i] = out[i - 1] * nums[i - 1];
        }

        int mul = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            out[i] *= mul;
            mul *= nums[i];
        }

        return out;
    }
}