package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 901. Online Stock Span
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsonline-stock-span
 */
class StockSpanner {
    Deque<int[]> decStack;
    int day = 0;

    public StockSpanner() {
        decStack = new ArrayDeque<>();
    }

    public int next(int price) {
        int idx = day++;
        while (!decStack.isEmpty() && decStack.peek()[1] <= price)
            decStack.pop();

        int idxOfPrevGreater = decStack.isEmpty() ? -1 : decStack.peek()[0];
        decStack.push(new int[]{idx, price});
        return idx - idxOfPrevGreater;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
