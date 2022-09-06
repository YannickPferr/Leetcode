package twopointers.hard;

/**
 * Problem: 42. Trapping Rain Water
 * Difficulty: Hard
 * Link: https://leetcode.com/problemstrapping-rain-water
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        maxLeft[0] = 0;
        int currMax = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = currMax;
            currMax = Math.max(currMax, height[i]);
        }

        int trap = 0;
        currMax = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            trap += Math.max(0, Math.min(maxLeft[i], currMax) - height[i]);
            currMax = Math.max(currMax, height[i]);
        }

        return trap;
    }
}