package other.easy;

import java.util.Arrays;

/**
 * Problem: 1122. Relative Sort Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsrelative-sort-array
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int[] count = new int[1001];
        for (int num : arr1)
            count[num]++;

        int[] res = new int[arr1.length];
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int k = 0; k < count[arr2[i]]; k++)
                res[j++] = arr2[i];
            count[arr2[i]] = 0;
        }

        for (int i = 0; i < arr1.length; i++) {
            while (count[arr1[i]] > 0) {
                res[j++] = arr1[i];
                count[arr1[i]]--;
            }
        }

        return res;
    }
}