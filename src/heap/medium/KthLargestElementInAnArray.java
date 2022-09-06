package heap.medium;

/**
 * Problem: 215. Kth Largest Element in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problemskth-largest-element-in-an-array
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, k, 0, nums.length - 1);
    }

    public int quickselect(int[] nums, int k, int start, int end) {
        int idx = partition(nums, start, end);
        if (idx == nums.length - k)
            return nums[idx];
        if (idx < nums.length - k)
            return quickselect(nums, k, idx, end);
        return quickselect(nums, k, start, idx - 1);
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int l = start;
        int r = end - 1;
        while (l <= r) {
            if (nums[l] <= pivot) {
                l++;
                continue;
            }
            if (nums[r] > pivot) {
                r--;
                continue;
            }
            swap(nums, l, r);
        }
        swap(nums, l, end);
        return l;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}