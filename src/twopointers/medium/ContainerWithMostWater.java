package twopointers.medium;

/**
 * Problem: 11. Container With Most Water
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscontainer-with-most-water
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;

        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(area, max);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return max;
    }
}