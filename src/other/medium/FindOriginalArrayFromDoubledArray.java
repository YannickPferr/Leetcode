package other.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem: 2007. Find Original Array From Doubled Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfind-original-array-from-doubled-array
 */
public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0)
            return new int[0];

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : changed)
            count.put(num, count.getOrDefault(num, 0) + 1);
        Arrays.sort(changed);
        int[] original = new int[changed.length / 2];
        int k = 0;
        for (int i = 0; i < changed.length; i++) {
            if (count.getOrDefault(changed[i], 0).intValue() > 0) {
                count.put(changed[i], count.get(changed[i]) - 1);
                if (count.getOrDefault(changed[i] * 2, 0).intValue() > 0) {
                    original[k++] = changed[i];
                    count.put(changed[i] * 2, count.get(changed[i] * 2) - 1);

                    if (k >= original.length)
                        return original;
                } else
                    return new int[0];
            }
        }
        return new int[0];
    }
}