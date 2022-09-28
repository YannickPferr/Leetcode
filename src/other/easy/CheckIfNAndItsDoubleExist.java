package other.easy;

import java.util.HashSet;

/**
 * Problem: 1346. Check If N and Its Double Exist
 * Difficulty: Easy
 * Link: https://leetcode.com/problemscheck-if-n-and-its-double-exist
 */
public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (hs.contains(arr[i] * 2) || (arr[i] % 2 == 0 && hs.contains(arr[i] / 2)))
                return true;
            hs.add(arr[i]);
        }
        return false;
    }
}