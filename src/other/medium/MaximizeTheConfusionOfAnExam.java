package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2024. Maximize the Confusion of an Exam
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsmaximize-the-confusion-of-an-exam
    */
    public class MaximizeTheConfusionOfAnExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] answerCount = new int[2];
        int max = 0;
        int start = 0;
        for(int i = 0; i < answerKey.length(); i++){
            max = Math.max(max, i - start);
            int key = answerKey.charAt(i) == 'T' ? 0 : 1;
            answerCount[key]++;
            int minElCount = Math.min(answerCount[0], answerCount[1]);
            while(minElCount > k){
                int keyAtStart = answerKey.charAt(start) == 'T' ? 0 : 1;
                answerCount[keyAtStart]--;
                start++;
                minElCount = Math.min(answerCount[0], answerCount[1]);
            }
        }
        return Math.max(max, answerKey.length() - start);
    }
}