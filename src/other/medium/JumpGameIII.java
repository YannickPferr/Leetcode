package other.medium;

/**
 * Problem: 1306. Jump Game III
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsjump-game-iii
 */
public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }

    public boolean dfs(int[] arr, int pos, boolean[] visited) {
        if (pos >= arr.length || pos < 0)
            return false;
        if (visited[pos])
            return false;
        if (arr[pos] == 0)
            return true;

        visited[pos] = true;
        boolean forward = dfs(arr, pos + arr[pos], visited);
        boolean backward = dfs(arr, pos - arr[pos], visited);
        return forward || backward;
    }
}