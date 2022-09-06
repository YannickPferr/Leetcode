package other.medium;

import java.util.Arrays;

/**
 * Problem: 505. The Maze II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsthe-maze-ii
 */
public class TheMazeII {
    int min = Integer.MAX_VALUE;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distances = new int[maze.length][maze[0].length];
        for (int[] row : distances)
            Arrays.fill(row, Integer.MAX_VALUE);
        dfs(maze, start[0], start[1], destination, distances, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(int[][] maze, int i, int j, int[] destination, int[][] distances, int pathLen) {
        if (i >= maze.length || j >= maze[0].length || i < 0 || j < 0)
            return;
        if (distances[i][j] <= pathLen)
            return;
        if (maze[i][j] == 1)
            return;
        if (i == destination[0] && j == destination[1])
            min = Math.min(min, pathLen);

        distances[i][j] = pathLen;
        int pathLenDown = pathLen;
        int start = i + 1;
        for (; start < maze.length && maze[start][j] != 1; start++)
            pathLenDown++;
        dfs(maze, start - 1, j, destination, distances, pathLenDown);

        int pathLenUp = pathLen;
        start = i - 1;
        for (; start >= 0 && maze[start][j] != 1; start--)
            pathLenUp++;
        dfs(maze, start + 1, j, destination, distances, pathLenUp);

        int pathLenLeft = pathLen;
        start = j - 1;
        for (; start >= 0 && maze[i][start] != 1; start--)
            pathLenLeft++;
        dfs(maze, i, start + 1, destination, distances, pathLenLeft);

        int pathLenRight = pathLen;
        start = j + 1;
        for (; start < maze[0].length && maze[i][start] != 1; start++)
            pathLenRight++;
        dfs(maze, i, start - 1, destination, distances, pathLenRight);
    }
}