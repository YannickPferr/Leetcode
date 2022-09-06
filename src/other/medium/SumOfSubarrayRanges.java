package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 2104. Sum of Subarray Ranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssum-of-subarray-ranges
 */
public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        Deque<Integer> inc = new ArrayDeque<>();
        Deque<Integer> dec = new ArrayDeque<>();
        long result = 0;
        for (int i = 0; i <= nums.length; i++) {
            while (!inc.isEmpty() && (i == nums.length || nums[i] < nums[inc.peek()])) {
                int curr = inc.pop();
                int left = inc.isEmpty() ? -1 : inc.peek();
                int right = i;
                result -= ((curr - left) * (right - curr) * (long) nums[curr]);
            }
            inc.push(i);

            while (!dec.isEmpty() && (i == nums.length || nums[i] > nums[dec.peek()])) {
                int curr = dec.pop();
                int left = dec.isEmpty() ? -1 : dec.peek();
                int right = i;
                result += ((curr - left) * (right - curr) * (long) nums[curr]);
            }
            dec.push(i);
        }
        return result;
    }
}
