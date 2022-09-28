package heap.easy;

/**
 * Problem: 1046. Last Stone Weight
 * Difficulty: Easy
 * Link: https://leetcode.com/problemslast-stone-weight
 */
public class LastStoneWeight {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int countZero = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i - start);
            if (nums[i] == 0) {
                countZero++;
                while (countZero > k)
                    countZero += (nums[start++] - 1);
            }
        }
        return Math.max(max, nums.length - start);
    }
}