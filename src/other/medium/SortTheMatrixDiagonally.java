package other.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem: 1329. Sort the Matrix Diagonally
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssort-the-matrix-diagonally
 */
public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        for (int i = mat.length - 1; i >= 0; i--)
            sortDiag(mat, i, 0);

        for (int j = 1; j < mat[0].length; j++)
            sortDiag(mat, 0, j);

        return mat;
    }

    public void sortDiag(int[][] mat, int startI, int startJ) {
        ArrayList<Integer> diag = new ArrayList<>();
        int i = startI;
        int j = startJ;
        while (i < mat.length && j < mat[0].length)
            diag.add(mat[i++][j++]);
        Collections.sort(diag);

        i = startI;
        j = startJ;
        int idx = 0;
        while (i < mat.length && j < mat[0].length)
            mat[i++][j++] = diag.get(idx++);
    }
}