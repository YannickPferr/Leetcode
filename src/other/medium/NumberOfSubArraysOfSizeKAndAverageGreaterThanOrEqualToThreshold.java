package other.medium;

/**
 * Problem: 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnumber-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold
 */
public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0;
        int window = 0;
        for (int i = 0; i < k; i++)
            window += arr[i];
        int th = k * threshold;
        int num = 0;
        if (window >= th)
            num++;
        for (int i = k; i < arr.length; i++) {
            window -= arr[start];
            window += arr[i];
            start++;
            if (window >= th)
                num++;
        }
        return num;
    }
}