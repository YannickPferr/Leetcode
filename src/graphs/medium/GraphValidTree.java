package graphs.medium;

/**
 * Problem: 178. Graph Valid Tree
 * Difficulty: Medium
 * Link: https://www.lintcode.com/problem/178/description
 */

public class GraphValidTree {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    int[] parent;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        // write your code here
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1]))
                return false;
            else
                union(edge[0], edge[1]);
        }
        return true;
    }

    public int find(int x) {
        if (x == parent[x])
            return x;
        return find(parent[x]);
    }

    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }
}