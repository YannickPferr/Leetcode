package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 1570. Dot Product of Two Sparse Vectors
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdot-product-of-two-sparse-vectors
 */
public class DotProductOfTwoSparseVectors {
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