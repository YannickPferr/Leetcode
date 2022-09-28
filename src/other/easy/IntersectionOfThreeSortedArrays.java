package other.easy;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

/**
 * Problem: 1213. Intersection of Three Sorted Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsintersection-of-three-sorted-arrays
 */
public class IntersectionOfThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> l = new ArrayList<>();
        for (int num : arr1) {
            if (Arrays.binarySearch(arr2, num) >= 0 && Arrays.binarySearch(arr3, num) >= 0)
                l.add(num);
        }
        return l;
    }
}