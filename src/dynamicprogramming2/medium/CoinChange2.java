package dynamicprogramming2.medium;

/**
 * Problem: 518. Coin Change 2
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscoin-change-2
 */
public class CoinChange2 {
    Integer[][] cache;

    public int change(int amount, int[] coins) {
        cache = new Integer[amount + 1][coins.length];
        return rec(coins, 0, amount);
    }

    public int rec(int[] coins, int pos, int amount) {
        if (amount < 0)
            return 0;
        if (amount == 0)
            return 1;
        if (cache[amount][pos] != null)
            return cache[amount][pos];

        int count = 0;
        for (int i = pos; i < coins.length; i++) {
            int coin = coins[i];
            count += rec(coins, i, amount - coin);
        }

        cache[amount][pos] = count;
        return count;
    }
}