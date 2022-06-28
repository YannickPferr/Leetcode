package other.easy;

/**
 * Problem: 1460. Make Two Arrays Equal by Reversing Sub-arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmake-two-arrays-equal-by-reversing-sub-arrays
 */
public class MakeTwoArraysEqualByReversingSubArrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] hm = new int[1001];
        for (int i : arr)
            hm[i] = hm[i] + 1;

        int[] hm2 = new int[1001];
        for (int i : target)
            hm2[i] = hm2[i] + 1;

        for (int i : arr) {
            if (hm2[i] == 0 || hm2[i] != hm[i])
                return false;
        }

        return true;
    }
}