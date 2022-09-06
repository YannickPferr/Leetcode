package other.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Problem: 496. Next Greater Element I
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsnext-greater-element-i
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i])
                stack.pop();
            if (stack.isEmpty())
                hm.put(nums2[i], -1);
            else
                hm.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = hm.get(nums1[i]);
        return nums1;
    }
}