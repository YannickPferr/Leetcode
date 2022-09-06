package dynamicprogramming1.medium;

/**
 * Problem: 152. Maximum Product Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximum-product-subarray
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currMax == 0)
                currMax = 1;
            if (currMin == 0)
                currMin = 1;

            int tmp = currMax * nums[i];
            currMax = Math.max(currMax * nums[i], Math.max(currMin * nums[i], nums[i]));
            currMin = Math.min(tmp, Math.min(currMin * nums[i], nums[i]));
            max = Math.max(currMax, Math.max(currMin, max));
        }
        return max;
    }
}