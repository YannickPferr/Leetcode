package other.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 1331. Rank Transform of an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsrank-transform-of-an-array
 */
public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] val = arr.clone();
        Arrays.sort(val);
        Map<Integer, Integer> mpp = new HashMap<Integer, Integer>();
        for (int a : val) mpp.putIfAbsent(a, mpp.size() + 1);
        for (int i = 0; i < arr.length; i++) arr[i] = mpp.get(arr[i]);
        return arr;
    }
}