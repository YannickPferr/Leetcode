package backtracking.medium;

/**
 * Problem: 79. Word Search
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsword-search
 */
public class WordSearch {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                visited = new boolean[board.length][board[0].length];
                if (word.charAt(0) == board[i][j] && backtracking(board, i, j, word, 0))
                    return true;
            }
        return false;
    }

    public boolean backtracking(char[][] board, int i, int j, String word, int pos) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j])
            return false;

        visited[i][j] = true;
        if (board[i][j] == word.charAt(pos)) {
            if (pos == word.length() - 1)
                return true;
            else {
                if (backtracking(board, i + 1, j, word, pos + 1) || backtracking(board, i - 1, j, word, pos + 1) || backtracking(board, i, j + 1, word, pos + 1) || backtracking(board, i, j - 1, word, pos + 1))
                    return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}