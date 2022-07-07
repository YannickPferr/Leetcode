package heap.medium;

import java.util.Arrays;

/**
 * Problem: 215. Kth Largest Element in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problemskth-largest-element-in-an-array
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        //sort solution faster than quickselect, even though qs is avg of O(n)
        Arrays.sort(nums);
        return nums[nums.length - k];
        //return quickselect(nums, 0, nums.length - 1, k);
    }

    public int quickselect(int[] nums, int start, int end, int k) {
        int idx = partition(nums, start, end);
        if (idx == nums.length - k)
            return nums[idx];
        else if (idx < nums.length - k)
            return quickselect(nums, idx + 1, end, k);
        else
            return quickselect(nums, start, idx - 1, k);
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int l = start;
        int r = end - 1;
        while (l <= r) {
            if (nums[l] < pivot) {
                l++;
                continue;
            }
            if (nums[r] > pivot) {
                r--;
                continue;
            }

            swap(nums, l, r);
            l++;
            r--;
        }
        swap(nums, l, end);
        return l;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}