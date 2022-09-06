package other.easy;

/**
 * Problem: 1064. Fixed Point
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfixed-point
 */
public class FixedPoint {
    public int fixedPoint(int[] arr) {
        int idx = -1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == mid) {
                idx = mid;
                r = mid - 1;
            } else if (arr[mid] > mid)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return idx;
    }
}