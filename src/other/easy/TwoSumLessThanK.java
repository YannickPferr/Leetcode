package other.easy;

import java.util.Arrays;

/**
 * Problem: 1099. Two Sum Less Than K
 * Difficulty: Easy
 * Link: https://leetcode.com/problemstwo-sum-less-than-k
 */
public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        int max = -1;
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum >= k) {
                r--;
                continue;
            }

            max = Math.max(max, sum);
            l++;
        }
        return max;
    }
}