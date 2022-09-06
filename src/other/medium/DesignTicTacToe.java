package other.medium;

/**
 * Problem: 348. Design Tic-Tac-Toe
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdesign-tic-tac-toe
 */
class TicTacToe {

    char[][] board;
    int[] rowSum;
    int[] colSum;
    int diagSum1;
    int diagSum2;

    public TicTacToe(int n) {
        board = new char[n][n];
        rowSum = new int[n];
        colSum = new int[n];
        diagSum1 = 0;
        diagSum2 = 0;
    }

    public int move(int row, int col, int player) {
        board[row][col] = Character.forDigit(player, 10);
        int numToAdd = player == 1 ? 1 : -1;
        rowSum[row] += numToAdd;
        colSum[col] += numToAdd;
        if (row == col)
            diagSum1 += numToAdd;
        if (row + col == board.length - 1)
            diagSum2 += numToAdd;

        if (Math.abs(rowSum[row]) == board.length || Math.abs(colSum[col]) == board.length || Math.abs(diagSum1) == board.length || Math.abs(diagSum2) == board.length)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */