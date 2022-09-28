package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2067. Number of Equal Count Substrings
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsnumber-of-equal-count-substrings
    */
    public class NumberOfEqualCountSubstrings {
    public int equalCountSubstrings(String s, int count) {
        int total = 0;
        int len = Math.min(s.length(), 26);
        for(int k = 1; k <= len; k++){
            int[] hm = new int[26];
            int start = 0;
            int hasCount = 0;
            for(int i = 0; i < s.length(); i++){
                hm[s.charAt(i) - 'a']++;
                if(hm[s.charAt(i) - 'a'] == count)
                    hasCount++;
                if(i + 1 - start > k*count){
                    hm[s.charAt(start) - 'a']--;
                    if(hm[s.charAt(start) - 'a'] == count - 1)
                        hasCount--;
                    start++;
                }
                if(hasCount == k)
                    total++;
            }
        }
        return total;
    }
}