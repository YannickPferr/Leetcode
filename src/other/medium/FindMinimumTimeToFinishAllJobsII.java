package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2323. Find Minimum Time to Finish All Jobs II
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsfind-minimum-time-to-finish-all-jobs-ii
    */
    public class FindMinimumTimeToFinishAllJobsII {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int max = 0;
        for(int i = 0; i < jobs.length; i++)
            max = Math.max((int)Math.ceil((double)jobs[i] / workers[i]), max);
        return max;
    }
}