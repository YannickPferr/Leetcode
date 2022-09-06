package other.medium;

/**
 * Problem: 276. Paint Fence
 * Difficulty: Medium
 * Link: https://leetcode.com/problemspaint-fence
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 1)
            return k;

        int numWays[] = new int[n];
        numWays[0] = k;
        numWays[1] = k * k;
        for (int i = 2; i < n; i++)
            numWays[i] = (numWays[i - 1] + numWays[i - 2]) * (k - 1);

        return numWays[n - 1];
    }
}