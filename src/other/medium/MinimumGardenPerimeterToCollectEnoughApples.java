package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 1954. Minimum Garden Perimeter to Collect Enough Apples
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsminimum-garden-perimeter-to-collect-enough-apples
    */
    public class MinimumGardenPerimeterToCollectEnoughApples {
    public long minimumPerimeter(long neededApples) {
        long l = 1;
        long r = 1000000;
        long min = 0;
        while(l <= r){
            long m = l + (r - l) / 2;
            long numApples = 2 * m*(m+1)*(2*m+1);
            if(numApples == neededApples)
                return 8*m;
            else if(numApples > neededApples){
                min = 8*m;
                r = m - 1;
            } else
                l = m + 1;
        }
        return min;
    }
}
