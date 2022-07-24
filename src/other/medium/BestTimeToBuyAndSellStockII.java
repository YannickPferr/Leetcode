package other.medium;

/**
 * Problem: 122. Best Time to Buy and Sell Stock II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsbest-time-to-buy-and-sell-stock-ii
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }

        return profit;
    }
}