package other.medium;

/**
 * Problem: 1011. Capacity To Ship Packages Within D Days
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscapacity-to-ship-packages-within-d-days
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int[] prefixSum = new int[weights.length];
        prefixSum[0] = weights[0];
        int maxWeight = weights[0];
        for (int i = 1; i < weights.length; i++) {
            prefixSum[i] = weights[i] + prefixSum[i - 1];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        int l = maxWeight;
        int r = maxWeight * weights.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            //int daysToShip = daysToShip(weights, m, days);
            if (isOK(m, weights, days))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    private boolean isOK(int guess, int[] arr, int d) { //return true if we can make the trip under d days with capacity of guess
        int sum = 0;
        for (int n : arr) {
            if (sum + n > guess) {
                sum = 0;
                d--;
            }
            sum += n;
        }

        return d > 0;
    }

    public int daysToShip(int[] prefixSum, int capacity, int maxDays) {
        int days = 0;
        int lastPicked = -1;
        while (lastPicked < prefixSum.length - 1 && days <= maxDays) {
            int l = lastPicked + 1;
            int r = prefixSum.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                int sumUntilLastPicked = lastPicked == -1 ? 0 : prefixSum[lastPicked];
                if (prefixSum[m] - sumUntilLastPicked > capacity)
                    r = m;
                else
                    l = m + 1;
            }
            lastPicked = l - 1;
            days++;
        }
        return days;
    }
}
//1 3 6 10 15 21 28 36 45 55
//3 5 7 11 12 16