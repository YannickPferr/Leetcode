package other.medium;

/**
 * Problem: 370. Range Addition
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsrange-addition
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            arr[update[0]] += update[2];
            if (update[1] + 1 < arr.length)
                arr[update[1] + 1] -= update[2];
        }
        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];

        return arr;
    }
}