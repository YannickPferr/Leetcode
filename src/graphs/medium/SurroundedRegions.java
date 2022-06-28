package graphs.medium;

/**
 * Problem: 130. Surrounded Regions
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssurrounded-regions
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1)
                    if (board[i][j] == 'O')
                        dfs(board, i, j);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = board[i][j] == 'I' ? 'O' : 'X';
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;
        if (board[i][j] != 'O')
            return;

        board[i][j] = 'I';
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
    }
}