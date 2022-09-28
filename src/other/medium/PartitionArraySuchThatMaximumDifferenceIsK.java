package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2294. Partition Array Such That Maximum Difference Is K
    * Difficulty: Medium
    * Link: https://leetcode.com/problemspartition-array-such-that-maximum-difference-is-k
    */
    public class PartitionArraySuchThatMaximumDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        //Arrays.sort(nums);
        int[] freq = new int[100001];
        int start = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            start = Math.min(start, nums[i]);
            freq[nums[i]]++;
        }
        
        int count = 0;
        for(int i = 0; i < freq.length; i++){
            while(freq[i] > 0){
                if(i - start > k){
                    count++;
                    start = i;
                }
                freq[i]--;
            }
        }
        return count + 1;
    }
}