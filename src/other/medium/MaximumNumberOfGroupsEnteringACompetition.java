package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2358. Maximum Number of Groups Entering a Competition
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsmaximum-number-of-groups-entering-a-competition
    */
    public class MaximumNumberOfGroupsEnteringACompetition {
    public int maximumGroups(int[] grades) {
        int numGroups = 0;
        for(int i = 0; i < grades.length; i+=numGroups+1)
            numGroups++;
        return numGroups;
    }
}