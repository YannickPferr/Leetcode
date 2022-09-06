package greedy.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem: 846. Hand of Straights
 * Difficulty: Medium
 * Link: https://leetcode.com/problemshand-of-straights
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Arrays.sort(hand);
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : hand)
            count.put(num, count.getOrDefault(num, 0) + 1);

        for (int num : hand) {
            if (count.get(num) <= 0)
                continue;

            for (int i = num; i < num + groupSize; i++) {
                int countI = count.getOrDefault(i, 0);
                if (countI == 0)
                    return false;

                count.put(i, countI - 1);
            }
        }
        return true;
    }
}