package dynamicprogramming2.medium;

/**
 * Problem: 309. Best Time to Buy and Sell Stock with Cooldown
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsbest-time-to-buy-and-sell-stock-with-cooldown
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    Integer[][] cache;

    public int maxProfit(int[] prices) {
        cache = new Integer[prices.length][2];
        return rec(prices, 0, -1);
    }

    public int rec(int[] prices, int pos, int buyPrice) {
        if (pos >= prices.length)
            return 0;
        else if (cache[pos][buyPrice == -1 ? 0 : 1] != null)
            return cache[pos][buyPrice == -1 ? 0 : 1];
        else {
            int best = 0;
            for (int i = pos; i < prices.length; i++) {
                if (buyPrice != -1)
                    best = Math.max(rec(prices, i + 2, -1) + (prices[i] - buyPrice), best);
                else
                    best = Math.max(rec(prices, i + 1, prices[i]), best);
            }
            cache[pos][buyPrice == -1 ? 0 : 1] = best;
            return best;
        }
    }
}