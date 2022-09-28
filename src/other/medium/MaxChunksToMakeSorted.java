package other.medium;

/**
 * Problem: 769. Max Chunks To Make Sorted
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmax-chunks-to-make-sorted
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                count++;
        }
        return count;
    }
}