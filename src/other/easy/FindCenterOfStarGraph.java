package other.easy;

/**
 * Problem: 1791. Find Center of Star Graph
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-center-of-star-graph
 */
public class FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        int[] nodes = new int[100000];
        for (int[] edge : edges) {
            nodes[edge[0] - 1]++;
            nodes[edge[1] - 1]++;
        }

        for (int i = 0; i < nodes.length; i++) {
            int count = nodes[i];
            if (count == edges.length)
                return i + 1;

        }

        return -1;
    }
}