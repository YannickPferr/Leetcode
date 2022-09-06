package other.easy;

/**
 * Problem: 303. Range Sum Query - Immutable
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsrange-sum-query-immutable
 */
class NumArray {

    int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] + nums[i];
    }

    public int sumRange(int left, int right) {
        return prefix[right] - (left - 1 >= 0 ? prefix[left - 1] : 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */