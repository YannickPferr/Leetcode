package other.easy;

import java.util.Arrays;

/**
 * Problem: 1539. Kth Missing Positive Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problemskth-missing-positive-number
 */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int missing = -1;
        for (int num = 1; i < k; num++) {
            int idx = Arrays.binarySearch(arr, num);
            if (idx < 0) {
                missing = num;
                i++;
            }
        }
        return missing;
    }
}