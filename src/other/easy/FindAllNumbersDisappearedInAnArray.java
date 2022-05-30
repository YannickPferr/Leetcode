package other.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 448. Find All Numbers Disappeared in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-all-numbers-disappeared-in-an-array
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++)
            l.add(i);

        for (int num : nums)
            l.set(num - 1, -1);

        int i = 0;
        while (i < l.size()) {
            if (l.get(i) == -1)
                l.remove(i);
            else
                i++;
        }


        return l;
    }
}