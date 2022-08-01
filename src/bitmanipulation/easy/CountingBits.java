package bitmanipulation.easy;

/**
 * Problem: 338. Counting Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problemscounting-bits
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                count += (num & 1);
                num = num >> 1;
            }
            arr[i] = count;
        }
        return arr;
    }
}