package other.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 2089. Find Target Indices After Sorting Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-target-indices-after-sorting-array
 */
public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int idx = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                idx = mid;
                r = mid - 1;
            } else if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = idx; i != -1 && i < nums.length && nums[i] == target; i++)
            list.add(i);
        return list;
    }
}