package other.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 560. Subarray Sum Equals K
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssubarray-sum-equals-k
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 1; i <= nums.length; i++)
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];

        HashMap<Integer, List<Integer>> seen = new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (seen.containsKey(prefixSum[i] - k))
                sum += seen.get(prefixSum[i] - k).size();
            List<Integer> l = seen.getOrDefault(prefixSum[i], new ArrayList<>());
            l.add(i);
            seen.put(prefixSum[i], l);
        }
        return sum;
    }
}