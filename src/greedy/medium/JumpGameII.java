package greedy.medium;

/**
 * Problem: 45. Jump Game II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/jump-game-ii
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int[] goal = new int[nums.length];
        goal[goal.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int min = nums.length;
            for (int j = 1; j <= nums[i] && i + j < goal.length; j++)
                min = Math.min(min, goal[i + j]);
            goal[i] = min + 1;
        }

        return goal[0];
    }

}