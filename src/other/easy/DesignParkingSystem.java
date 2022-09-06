package other.easy;

/**
 * Problem: 1603. Design Parking System
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsdesign-parking-system
 */
public class DesignParkingSystem {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            runningSum[i] = nums[i] + runningSum[i - 1];
        return runningSum;
    }
}