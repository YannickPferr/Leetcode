package other.medium;

/**
 * Problem: 852. Peak Index in a Mountain Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspeak-index-in-a-mountain-array
 */
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1;
        int r = arr.length - 2;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[m + 1])
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
//[24,69,100,99,79,78,67,36,26,19]