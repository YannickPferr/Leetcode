package other.easy;

/**
 * Problem: 1002. Find Common Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-common-characters
 */
public class FindCommonCharacters {
    public int maxWidthRamp(int[] nums) {
        int[] maxRight = new int[nums.length];
        maxRight[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--)
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);

        int max = 0;
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            while (left < right && nums[left] > maxRight[right])
                left++;
            max = Math.max(max, right - left);
            right++;
        }
        return max;
    }
}
