package other.medium;

/**
 * Problem: 1628. Design an Expression Tree With Evaluate Function
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdesign-an-expression-tree-with-evaluate-function
 */
public class DesignAnExpressionTreeWithEvaluateFunction {
    public int numSubmat(int[][] mat) {
        int[][] left = new int[mat.length][mat[0].length];

        int count = 0;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                if (mat[i][j] == 1) {
                    left[i][j] = (j - 1 >= 0 ? left[i][j - 1] : 0) + 1;
                    int min = left[i][j];
                    for (int k = i; k >= 0; k--) {
                        if (mat[k][j] == 0)
                            break;
                        min = Math.min(min, left[k][j]);
                        count += min;
                    }
                }

        return count;
    }

    public int count(int[][] mat, int startI, int startJ) {
        int count = 0;
        int bound = mat[startI].length;
        for (int i = startI; i < mat.length; i++)
            for (int j = startJ; j < bound; j++) {
                if (mat[i][j] == 1)
                    count++;
                else
                    bound = j;
            }
        return count;
    }
}