package other.medium;

/**
 * Problem: 1155. Number of Dice Rolls With Target Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnumber-of-dice-rolls-with-target-sum
 */
public class NumberOfDiceRollsWithTargetSum {
    Integer[][] cache;

    public int numRollsToTarget(int n, int k, int target) {
        cache = new Integer[n + 1][target + 1];
        return rec(k, n, target);
    }

    public int rec(int k, int throwsLeft, int target) {
        if (target == 0 && throwsLeft == 0)
            return 1;
        if (throwsLeft <= 0)
            return 0;
        if (target < 0)
            return 0;
        if (cache[throwsLeft][target] != null)
            return cache[throwsLeft][target];

        int ways = 0;
        for (int i = 1; i <= k; i++)
            ways = (ways + rec(k, throwsLeft - 1, target - i)) % 1000000007;
        cache[throwsLeft][target] = ways;
        return ways;
    }
}