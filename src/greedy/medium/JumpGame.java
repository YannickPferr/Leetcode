package greedy.medium;

/**
 * Problem: 55. Jump Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsjump-game
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--)
            if (i + nums[i] >= goal)
                goal = i;
        return goal == 0;
    }
}