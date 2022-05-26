package dynamicprogramming1.medium;

/**
 * Problem: 152. Maximum Product Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-product-subarray
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prod = nums[0] == 0 ? 1 : nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prod *= nums[i];
            max = Math.max(prod, max);

            if (prod == 0)
                prod = 1;
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            max = Math.max(prod, max);

            if (prod == 0)
                prod = 1;
        }

        return max;
    }
}