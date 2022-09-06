package other.medium;

/**
 * Problem: 323. Number of Connected Components in an Undirected Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsnumber-of-connected-components-in-an-undirected-graph
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    int[] parent;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int numConnected = n;
        for (int[] edge : edges) {
            if (find(edge[0]) != find(edge[1])) {
                numConnected--;
                union(edge[0], edge[1]);
            }
        }
        return numConnected;
    }

    public void union(int a, int b) {
        parent[find(b)] = find(a);
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }
}