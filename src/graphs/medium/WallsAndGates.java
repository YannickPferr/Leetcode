package graphs.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 663. Walls and Gates
 * Difficulty: Medium
 * Link: https://www.lintcode.com/problem/663
 */

public class WallsAndGates {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        Deque<Integer[]> q = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[i].length; j++)
                if (rooms[i][j] == 0)
                    q.add(new Integer[]{i, j});

        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer[] room = q.poll();
                int x = room[0];
                int y = room[1];
                visited[x][y] = true;
                if (rooms[x][y] > level)
                    rooms[x][y] = level;
                pushNeighbors(rooms, x + 1, y, q, visited);
                pushNeighbors(rooms, x - 1, y, q, visited);
                pushNeighbors(rooms, x, y + 1, q, visited);
                pushNeighbors(rooms, x, y - 1, q, visited);
            }
            level++;
        }
    }

    public void pushNeighbors(int[][] rooms, int x, int y, Deque<Integer[]> q, boolean[][] visited) {
        if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[x].length)
            if (rooms[x][y] != -1 && rooms[x][y] != 0 && !visited[x][y])
                q.add(new Integer[]{x, y});
    }
}