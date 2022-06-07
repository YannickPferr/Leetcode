package bitmanipulation.easy;

/**
 * Problem: 268. Missing Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmissing-number
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum ^= i ^ nums[i];
        return sum;
    }
}