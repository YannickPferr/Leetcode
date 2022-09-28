package other.medium;

import javax.management.relation.Relation;

/**
 * Problem: 277. Find the Celebrity
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-the-celebrity
 */
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public public class FindTheCelebrity extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 0; i < n; i++)
            if (knows(celebrity, i))
                celebrity = i;

        for (int i = 0; i < n; i++) {
            if (i == celebrity)
                continue;
            if (knows(celebrity, i) || !knows(i, celebrity))
                return -1;
        }
        return celebrity;
    }
}