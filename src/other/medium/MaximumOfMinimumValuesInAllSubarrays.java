package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 1950. Maximum of Minimum Values in All Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximum-of-minimum-values-in-all-subarrays
 */
public class MaximumOfMinimumValuesInAllSubarrays {
    public int[] findMaximums(int[] nums) {
        int[] answer = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() && (i == nums.length || nums[stack.peek()] >= nums[i])) {
                int curr = stack.pop();
                int start = stack.isEmpty() ? 0 : stack.peek() + 1;
                answer[i - start - 1] = Math.max(answer[i - start - 1], nums[curr]);
            }
            stack.push(i);
        }
        for (int i = nums.length - 2; i >= 0; i--)
            answer[i] = Math.max(answer[i + 1], answer[i]);
        return answer;
    }
}