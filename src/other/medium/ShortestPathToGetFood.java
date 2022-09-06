package other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 1730. Shortest Path to Get Food
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsshortest-path-to-get-food
 */
public class ShortestPathToGetFood {
    public int getFood(char[][] grid) {
        int[] start = new int[]{0, 0};
        int countFood = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*')
                    start = new int[]{i, j};
                if (grid[i][j] == '#')
                    countFood++;
            }
        }
        if (countFood == 0)
            return -1;

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(start);
        seen[start[0]][start[1]] = true;
        int pathLen = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] field = q.poll();
                int x = field[0];
                int y = field[1];
                if (grid[x][y] == '#')
                    return pathLen;

                if (x + 1 < grid.length && !seen[x + 1][y] && grid[x + 1][y] != 'X') {
                    q.add(new int[]{x + 1, y});
                    seen[x + 1][y] = true;
                }
                if (y + 1 < grid[0].length && !seen[x][y + 1] && grid[x][y + 1] != 'X') {
                    q.add(new int[]{x, y + 1});
                    seen[x][y + 1] = true;
                }
                if (x - 1 >= 0 && !seen[x - 1][y] && grid[x - 1][y] != 'X') {
                    q.add(new int[]{x - 1, y});
                    seen[x - 1][y] = true;
                }
                if (y - 1 >= 0 && !seen[x][y - 1] && grid[x][y - 1] != 'X') {
                    q.add(new int[]{x, y - 1});
                    seen[x][y - 1] = true;
                }
            }
            pathLen++;
        }
        return -1;
    }
}