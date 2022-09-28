package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2342. Max Sum of a Pair With Equal Sum of Digits
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsmax-sum-of-a-pair-with-equal-sum-of-digits
    */
    public class MaxSumOfAPairWithEqualSumOfDigits {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for(int num : nums){
            int digitSum = getDigitSum(num);
            if(map.containsKey(digitSum)){
                max = Math.max(max, num + map.get(digitSum));
                map.put(digitSum, Math.max(num, map.get(digitSum)));
            } else
                map.put(digitSum, num);
        }
        
        return max;
    }
    
    public int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}