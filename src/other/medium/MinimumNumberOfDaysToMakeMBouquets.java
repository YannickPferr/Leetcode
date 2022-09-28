package other.medium;

/**
 * Problem: 1482. Minimum Number of Days to Make m Bouquets
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-number-of-days-to-make-m-bouquets
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length / k < m)
            return -1;

        int max = 0;
        for (int bloom : bloomDay)
            max = Math.max(bloom, max);

        int l = 1;
        int r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isPossible(bloomDay, mid, m, k))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public boolean isPossible(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int currFlowers = 0;
        for (int bloom : bloomDay) {
            if (bloom <= days)
                currFlowers++;
            else
                currFlowers = 0;

            if (currFlowers == k) {
                bouquets++;
                currFlowers = 0;
                if (bouquets >= m)
                    return true;
            }
        }
        return false;
    }
}