package other.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Problem: 349. Intersection of Two Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsintersection-of-two-arrays
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        HashSet<Integer> hs1 = new HashSet<>();
        for (int num : nums1)
            hs1.add(num);

        HashSet<Integer> hs2 = new HashSet<>();
        for (int num : nums2)
            hs2.add(num);

        List<Integer> l = new ArrayList<>();
        for (int num : hs1)
            if (hs2.contains(num))
                l.add(num);

        int[] arr = new int[l.size()];
        for (int i = 0; i < l.size(); i++)
            arr[i] = l.get(i);

        return arr;
    }
}