package other.easy;

import java.util.Arrays;

/**
 * Problem: 2389. Longest Subsequence With Limited Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problemslongest-subsequence-with-limited-sum
 */
public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = 0;
            int windowSum = 0;
            int query = queries[i];
            for (int j = 0; j < nums.length; j++) {
                windowSum += nums[j];
                while (windowSum > query) {
                    windowSum -= nums[start];
                    start++;
                }
                answer[i] = Math.max(answer[i], j + 1 - start);
            }
        }
        return answer;
    }
}