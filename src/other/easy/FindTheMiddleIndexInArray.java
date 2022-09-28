package other.easy;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 1991. Find the Middle Index in Array
    * Difficulty: Easy
    * Link: https://leetcode.com/problemsfind-the-middle-index-in-array
    */
    public class FindTheMiddleIndexInArray {
    public int findMiddleIndex(int[] nums) {
        int[] prefix = new int[nums.length + 2];
        prefix[0] = 0;
        for(int i = 1; i <= nums.length; i++)
            prefix[i] = prefix[i - 1] + nums[i - 1];
        prefix[prefix.length - 1] = prefix[prefix.length - 2];
        
        for(int i = 1; i <= nums.length; i++)
            if(prefix[i - 1] == prefix[prefix.length - 1] - prefix[i])
                return i - 1;
        return -1;
    }
}