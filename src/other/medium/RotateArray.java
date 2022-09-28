package other.medium;

/**
 * Problem: 189. Rotate Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsrotate-array
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            int rotatedIdx = (nums.length - k + i) % nums.length;
            if (rotatedIdx >= 0)
                arr[i] = nums[rotatedIdx];
        }

        for (int i = 0; i < arr.length; i++)
            nums[i] = arr[i];
    }
}