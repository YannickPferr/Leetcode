package other.easy;

import java.util.Arrays;

/**
 * Problem: 1385. Find the Distance Value Between Two Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-the-distance-value-between-two-arrays
 */
public class FindTheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        loop:
        for (int i = 0; i < arr1.length; i++) {
            int l = 0;
            int r = arr2.length - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                int dist = Math.abs(arr1[i] - arr2[m]);
                if (dist <= d || arr2[m] > arr1[i])
                    r = m;
                else
                    l = m + 1;
            }
            if (Math.abs(arr1[i] - arr2[l]) > d)
                count++;
        }
        return count;
    }
}