package hashing.medium;

import java.util.HashSet;

/**
 * Problem: 36. Valid Sudoku
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;

                if (seen.contains(board[i][j] + "r" + i) || seen.contains(board[i][j] + "c" + j) || seen.contains(board[i][j] + "r" + i / 3 + "c" + j / 3))
                    return false;

                seen.add(board[i][j] + "r" + i);
                seen.add(board[i][j] + "c" + j);
                seen.add(board[i][j] + "r" + i / 3 + "c" + j / 3);
            }
        }

        return true;
    }
}
