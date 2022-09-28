package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2087. Minimum Cost Homecoming of a Robot in a Grid
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsminimum-cost-homecoming-of-a-robot-in-a-grid
    */
    public class MinimumCostHomecomingOfARobotInAGrid {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int dirX = homePos[0] < startPos[0] ? -1 : 1;
        int dirY = homePos[1] < startPos[1] ? -1 : 1;
        int cost = 0;
        for(int i = startPos[0] + dirX; i - dirX != homePos[0]; i += dirX)
            cost += rowCosts[i];
        for(int i = startPos[1] + dirY; i - dirY != homePos[1]; i += dirY)
            cost += colCosts[i];
        return cost;
    }
}