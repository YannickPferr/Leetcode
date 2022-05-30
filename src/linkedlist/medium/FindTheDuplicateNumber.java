package linkedlist.medium;

/**
 * Problem: 287. Find the Duplicate Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-the-duplicate-number
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }

        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}