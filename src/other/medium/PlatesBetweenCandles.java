package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2055. Plates Between Candles
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsplates-between-candles
    */
    public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] dp = new int[s.length()];
        int[] leftNext = new int[s.length()];
        int[] rightNext = new int[s.length()];
        
        int count = 0;
        int last = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            leftNext[i] = last;
            if(c == '|'){
                dp[i] = count;
                last = i;
                leftNext[i] = last;
            }
            else 
                count++;
        }
        
        last = -1;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            rightNext[i] = last;
            if(c == '|'){
                last = i;
                rightNext[i] = last;
            }
        }
        
        int[] answer = new int[queries.length];
        int i = 0;
        for(int[] query : queries){
            int start = rightNext[query[0]];
            int end = leftNext[query[1]];
            if(end >= start && end != -1 && start != -1)
                answer[i] = dp[end] - dp[start];
            i++;
        }
  
        return answer;

    }
}