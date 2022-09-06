package other.medium;

/**
 * Problem: 490. The Maze
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsthe-maze
 */
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start[0], start[1], destination, new boolean[maze.length][maze[0].length]);
    }

    public boolean dfs(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {
        if (i >= maze.length || j >= maze[0].length || i < 0 || j < 0)
            return false;
        if (visited[i][j])
            return false;
        if (maze[i][j] == 1)
            return false;
        if (i == destination[0] && j == destination[1])
            return true;

        visited[i][j] = true;
        int start = i + 1;
        for (; start < maze.length && maze[start][j] != 1; start++) ;
        if (dfs(maze, start - 1, j, destination, visited))
            return true;

        start = i - 1;
        for (; start >= 0 && maze[start][j] != 1; start--) ;
        if (dfs(maze, start + 1, j, destination, visited))
            return true;

        start = j - 1;
        for (; start >= 0 && maze[i][start] != 1; start--) ;
        if (dfs(maze, i, start + 1, destination, visited))
            return true;

        start = j + 1;
        for (; start < maze[0].length && maze[i][start] != 1; start++) ;
        if (dfs(maze, i, start - 1, destination, visited))
            return true;
        return false;
    }
}