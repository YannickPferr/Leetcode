package other.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 1475. Final Prices With a Special Discount in a Shop
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfinal-prices-with-a-special-discount-in-a-shop
 */
public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i])
                stack.pop();
            int top = stack.isEmpty() ? 0 : stack.peek();
            stack.push(prices[i]);
            prices[i] -= top;
        }
        return prices;
    }
}