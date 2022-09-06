package other.medium;

/**
 * Problem: 456. 132 Pattern
 * Difficulty: Medium
 * Link: https://leetcode.com/problems132-pattern
 */
public class 132Pattern{
public boolean find132pattern(int[]nums){
        Deque<Integer> stack=new ArrayDeque<>();
        int lastRemoved=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
        int num=nums[i];
        if(lastRemoved>num)
        return true;

        while(!stack.isEmpty()&&num>stack.peek())
        lastRemoved=stack.pop();
        stack.push(num);
        }
        return false;
        }
        }

//i < j < k
//nums[i] < nums[k] < nums[j]