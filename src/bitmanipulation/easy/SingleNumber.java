package bitmanipulation.easy;

/**
 * Problem: 136. Single Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problemssingle-number
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++)
            num ^= nums[i];
        return num;
    }
}