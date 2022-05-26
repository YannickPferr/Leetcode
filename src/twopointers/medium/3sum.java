package twopointers.medium;
/**
 * Problem: 15. 3Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/3sum
 */
public class 3sum{

public List<List<Integer>>threeSum(int[]nums){
        Set<List<Integer>>set=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
        int l=i+1;
        int r=nums.length-1;
        List<Integer> list=new ArrayList<>();
        list.add(nums[i]);
        while(l<r){
        int sum=nums[i]+nums[l]+nums[r];
        if(sum==0){
        list.add(nums[l]);
        list.add(nums[r]);
        set.add(list);
        list=new ArrayList<>();
        list.add(nums[i]);
        l++;
        r--;
        }
        else if(sum>0)
        r--;
        else if(sum< 0)
        l++;
        }
        }

        return new ArrayList<>(set);
        }
        }