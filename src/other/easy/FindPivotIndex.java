package other.easy;

/**
 * Problem: 724. Find Pivot Index
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-pivot-index
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length + 2];
        prefix[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            prefix[i] = prefix[i - 1] + nums[i - 1];
        prefix[prefix.length - 1] = prefix[prefix.length - 2];

        for (int i = 1; i <= nums.length; i++)
            if (prefix[i - 1] == prefix[prefix.length - 1] - prefix[i])
                return i - 1;
        return -1;
    }
}