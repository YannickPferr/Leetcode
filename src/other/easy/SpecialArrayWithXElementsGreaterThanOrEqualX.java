package other.easy;

import java.util.Arrays;

/**
 * Problem: 1608. Special Array With X Elements Greater Than or Equal X
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsspecial-array-with-x-elements-greater-than-or-equal-x
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= nums.length - m)
                r = m;
            else
                l = m + 1;
        }
        int potentialAnswer = nums.length - l;
        int left = l - 1 >= 0 ? nums[l - 1] : -1;
        return left >= potentialAnswer ? -1 : potentialAnswer;
    }
}
//0,3,6,7,7
//3,3,6,6,7,8,8,9
//0 0 3 4 4