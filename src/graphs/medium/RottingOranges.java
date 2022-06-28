package graphs.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 994. Rotting Oranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsrotting-oranges
 */
public class RottingOranges {

    class Orange {
        int i;
        int j;

        public Orange(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        Deque<Orange> q = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.add(new Orange(i, j));
                else if (grid[i][j] == 1)
                    count++;
            }
        if (count == 0)
            return 0;

        int min = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int x = 0; x < size; x++) {
                Orange rotten = q.poll();
                int i = rotten.i;
                int j = rotten.j;
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    count--;
                    grid[i + 1][j] = 2;
                    q.add(new Orange(i + 1, j));
                }
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    count--;
                    grid[i - 1][j] = 2;
                    q.add(new Orange(i - 1, j));
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    count--;
                    grid[i][j + 1] = 2;
                    q.add(new Orange(i, j + 1));
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    count--;
                    grid[i][j - 1] = 2;
                    q.add(new Orange(i, j - 1));
                }
            }
            min++;
        }
        if (count > 0)
            return -1;

        return min;
    }
}