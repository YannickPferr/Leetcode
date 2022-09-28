package other.easy;

/**
 * Problem: 441. Arranging Coins
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsarranging-coins
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n == 1)
            return 1;
        int l = 1;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            long neededCoins = m * (m + 1l) / 2l;
            if (neededCoins > n)
                r = m;
            else
                l = m + 1;
        }
        return l - 1;
    }
}