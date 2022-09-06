package other.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: 1329. Sort the Matrix Diagonally
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssort-the-matrix-diagonally
 */
public class SortTheMatrixDiagonally {
    int[][] output;

    public int[][] diagonalSort(int[][] mat) {
        output = new int[mat.length][mat[0].length];
        for (int i = mat.length - 1; i >= 0; i--)
            sortDiag(mat, i, 0);

        for (int j = 1; j < mat[0].length; j++)
            sortDiag(mat, 0, j);

        return output;
    }

    public void sortDiag(int[][] mat, int startI, int startJ) {
        List<Integer> l = new ArrayList<>();
        int i = startI;
        int j = startJ;
        while (i < mat.length && j < mat[0].length) {
            l.add(mat[i][j]);
            i++;
            j++;
        }
        Collections.sort(l);
        int k = 0;
        i = startI;
        j = startJ;
        while (i < mat.length && j < mat[0].length) {
            output[i][j] = l.get(k++);
            i++;
            j++;
        }
    }
}