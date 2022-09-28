package other.medium;

/**
 * Problem: 1871. Jump Game VII
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsjump-game-vii
 */
public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        int start = 0;
        boolean[] canReach = new boolean[s.length()];
        canReach[0] = true;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i - start > maxJump) {
                start++;
                while (!canReach[start] && start < i)
                    start++;
                if (start == i)
                    return false;
            }
            if (c == '0' && i - start >= minJump)
                canReach[i] = true;
        }
        return canReach[s.length() - 1];
    }
}