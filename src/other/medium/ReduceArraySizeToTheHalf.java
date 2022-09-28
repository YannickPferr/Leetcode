package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

/**
 * Problem: 1338. Reduce Array Size to The Half
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsreduce-array-size-to-the-half
 */
public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        int min = arr.length / 2;
        int[] count = new int[100001];
        for (int num : arr)
            count[num]++;

        int[] freqs = new int[arr.length + 1];
        for (int num : count)
            if (num > 0)
                freqs[num]++;

        int removed = 0;
        int k = 0;
        int i = arr.length;
        while (removed < min) {
            if (freqs[i] == 0) {
                i--;
                continue;
            }
            removed += i;
            k++;
            freqs[i]--;
        }
        return k;
    }
}