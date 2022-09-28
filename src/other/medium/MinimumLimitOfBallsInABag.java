package other.medium;

/**
 * Problem: 1760. Minimum Limit of Balls in a Bag
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-limit-of-balls-in-a-bag
 */
public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        int l = 1;
        int r = max;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isPossible(nums, maxOperations, m))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public boolean isPossible(int[] nums, int maxOps, int penalty) {
        int numOps = 0;
        for (int num : nums)
            if ((numOps += (num - 1) / penalty) > maxOps)
                return false;
        return true;
    }
}

