package other.easy;

import java.util.HashSet;

/**
 * Problem: 888. Fair Candy Swap
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfair-candy-swap
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        HashSet<Integer> hsa = new HashSet<>();
        int alice = 0;
        int bob = 0;
        for (int box : aliceSizes) {
            alice += box;
            hsa.add(box);
        }
        for (int box : bobSizes)
            bob += box;

        int total = alice + bob;
        for (int box : bobSizes)
            if ((alice + 2 * box - bob) % 2 == 0 && hsa.contains((alice + 2 * box - bob) / 2))
                return new int[]{(alice + 2 * box - bob) / 2, box};
        return new int[]{0, 0};
    }
}

