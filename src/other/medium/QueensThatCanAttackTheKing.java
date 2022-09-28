package other.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 1222. Queens That Can Attack the King
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsqueens-that-can-attack-the-king
 */
public class QueensThatCanAttackTheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> coordinates = new ArrayList<>();

        boolean[][] isQueen = new boolean[8][8];
        for (int[] queen : queens)
            isQueen[queen[0]][queen[1]] = true;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] dir : dirs)
            for (int i = 1; king[0] + i * dir[0] >= 0 && king[0] + i * dir[0] < 8 && king[1] + i * dir[1] >= 0 && king[1] + i * dir[1] < 8; i++) {
                if (isQueen[king[0] + i * dir[0]][king[1] + i * dir[1]]) {
                    coordinates.add(Arrays.asList(king[0] + i * dir[0], king[1] + i * dir[1]));
                    break;
                }
            }

        return coordinates;
    }
}