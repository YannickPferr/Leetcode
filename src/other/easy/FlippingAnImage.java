package other.easy;

/**
 * Problem: 832. Flipping an Image
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsflipping-an-image
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] newImage = new int[image.length][image.length];
        for (int i = 0; i < newImage.length; i++) {
            int newIdx = 0;
            for (int j = image.length - 1; j >= 0; j--)
                newImage[i][newIdx++] = image[i][j] == 0 ? 1 : 0;
        }
        return newImage;
    }
}