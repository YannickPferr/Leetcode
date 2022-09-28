package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2284. Sender With Largest Word Count
    * Difficulty: Medium
    * Link: https://leetcode.com/problemssender-with-largest-word-count
    */
    public class SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        int max = 0;
        for(int i = 0; i < messages.length; i++){
            int numWords = messages[i].split(" ").length;
            String user = senders[i];
            wordCount.put(user, wordCount.getOrDefault(user, 0) + numWords);
            max = Math.max(max, wordCount.get(user));
        }
        
        String maxSender = null;
        for(String sender : wordCount.keySet())
            if(wordCount.get(sender) == max)
                maxSender = maxSender == null||maxSender.compareTo(sender) < 0 ? sender : maxSender;
            
        return maxSender;
    }
}