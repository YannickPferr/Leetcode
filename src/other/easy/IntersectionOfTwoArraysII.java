package other.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 350. Intersection of Two Arrays II
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsintersection-of-two-arrays-ii
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hs1 = new HashMap<>();
        for (int num : nums1)
            hs1.put(num, hs1.getOrDefault(num, 0) + 1);

        HashMap<Integer, Integer> hs2 = new HashMap<>();
        for (int num : nums2)
            hs2.put(num, hs2.getOrDefault(num, 0) + 1);

        List<Integer> l = new ArrayList<>();
        for (int num : hs1.keySet()) {
            if (hs2.containsKey(num)) {
                int min = Math.min(hs1.get(num), hs2.get(num));
                for (int i = 0; i < min; i++)
                    l.add(num);
            }
        }
        int i = 0;
        int[] arr = new int[l.size()];
        for (int num : l)
            arr[i++] = num;
        return arr;
    }
}