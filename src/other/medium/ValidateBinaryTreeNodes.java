package other.medium;

/**
 * Problem: 1361. Validate Binary Tree Nodes
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsvalidate-binary-tree-nodes
 */
public class ValidateBinaryTreeNodes {
    int[] parents;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;

        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int root = find(i);
            if (left != -1) {
                if (find(left) == root)
                    return false;
                union(i, left);
            }
            int right = rightChild[i];
            if (right != -1) {
                if (find(right) == root)
                    return false;
                union(i, right);
            }
        }

        int root = find(0);
        for (int i = 1; i < n; i++) {
            if (find(i) != root)
                return false;
        }

        return true;
    }

    public void union(int x, int y) {
        parents[y] = find(x);
    }

    int find(int x) {
        if (parents[x] != x) {
            //Path compression for faster parent search - this makes Tree root as parent of all nodes
            parents[x] = find(parents[x]);
            return parents[x];
        }
        return x;
    }
}