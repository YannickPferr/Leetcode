package dynamicprogramming1.easy;

/**
 * Problem: 70. Climbing Stairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        return bottomUp(n);
    }

    public int bottomUp(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (i >= 2)
                dp[i] = dp[i - 2] + dp[i - 1];
            else
                dp[i] = dp[i - 1] + 1;
        }

        return dp[n - 1];
    }

    public int topDown(int n, int[] mem) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int one = mem[n - 1] != 0 ? mem[n - 1] : topDown(n - 1, mem);
        mem[n - 1] = one;
        int two = mem[n - 2] != 0 ? mem[n - 2] : topDown(n - 2, mem);
        mem[n - 2] = two;

        return one + two;
    }
}
