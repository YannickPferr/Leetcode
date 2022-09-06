package other.medium;

/**
 * Problem: 528. Random Pick with Weight
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsrandom-pick-with-weight
 */
public class RandomPickWithWeight {

    int sum;
    int[] prefix;

    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        sum = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
            sum += w[i];
        }
    }

    public int pickIndex() {
        double rand = sum * Math.random();
        int l = 0;
        int r = prefix.length - 1;
        int idx = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (rand < prefix[m]) {
                idx = m;
                r = m - 1;
            } else
                l = m + 1;
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */