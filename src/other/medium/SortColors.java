package other.medium;

/**
 * Problem: 75. Sort Colors
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssort-colors
 */
public class SortColors {
    public void sortColors(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    public void quicksort(int[] nums, int start, int end) {
        if (end <= start)
            return;

        int partIdx = partition(nums, start, end);
        quicksort(nums, start, partIdx - 1);
        quicksort(nums, partIdx + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        int j = end - 1;
        while (i <= j) {
            if (nums[i] < pivot) {
                i++;
                continue;
            }
            if (nums[j] > pivot) {
                j--;
                continue;
            }

            swap(nums, i, j);
            i++;
            j--;

        }
        swap(nums, i, end);
        return i;
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}