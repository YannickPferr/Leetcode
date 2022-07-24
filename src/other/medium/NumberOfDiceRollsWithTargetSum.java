package other.medium;

/**
 * Problem: 1155. Number of Dice Rolls With Target Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnumber-of-dice-rolls-with-target-sum
 */
public class NumberOfDiceRollsWithTargetSum {
    Integer[][] cache;

    public int numRollsToTarget(int n, int k, int target) {
        cache = new Integer[target + 1][n + 1];
        return rec(k, n, target);
    }

    public int rec(int k, int n, int target) {
        if (target == 0 && n == 0)
            return 1;
        if (target <= 0 || n <= 0)
            return 0;
        if (cache[target][n] != null)
            return cache[target][n];

        int count = 0;
        for (int i = 1; i <= k; i++)
            count = (count + rec(k, n - 1, target - i)) % 1000000007;
        cache[target][n] = count;
        return cache[target][n];
    }
}