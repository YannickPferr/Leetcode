package slidingwindow.easy;

/**
 * Problem: 121. Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsbest-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int lowestBuy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - lowestBuy, profit);
            lowestBuy = Math.min(prices[i], lowestBuy);
        }
        return profit;
    }
}