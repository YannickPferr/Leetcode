package other.easy;

/**
 * Problem: 733. Flood Fill
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsflood-fill
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int colorFrom, int colorTo) {
        if (i >= image.length || j >= image[0].length || i < 0 || j < 0)
            return;
        if (image[i][j] != colorFrom)
            return;
        if (image[i][j] == colorTo)
            return;

        image[i][j] = colorTo;
        dfs(image, i + 1, j, colorFrom, colorTo);
        dfs(image, i - 1, j, colorFrom, colorTo);
        dfs(image, i, j + 1, colorFrom, colorTo);
        dfs(image, i, j - 1, colorFrom, colorTo);
    }
}