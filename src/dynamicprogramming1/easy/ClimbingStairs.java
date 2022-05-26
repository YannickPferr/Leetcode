package dynamicprogramming1.easy;

/**
 * Problem: 70. Climbing Stairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/climbing-stairs
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        return rec(n, new int[n]);
    }

    public int rec(int n, int[] mem) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int one = mem[n - 1] != 0 ? mem[n - 1] : rec(n - 1, mem);
        mem[n - 1] = one;
        int two = mem[n - 2] != 0 ? mem[n - 2] : rec(n - 2, mem);
        mem[n - 2] = two;

        return one + two;
    }
}