package linkedlist.medium;

/**
 * Problem: 287. Find the Duplicate Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-the-duplicate-number
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];
        fast = nums[fast];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
