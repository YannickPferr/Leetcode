package other.medium;

/**
 * Problem: 1423. Maximum Points You Can Obtain from Cards
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmaximum-points-you-can-obtain-from-cards
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        for (int i : cardPoints)
            totalSum += i;

        int left = 0;
        int maxScore = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            if (i - left >= cardPoints.length - k) {
                maxScore = Math.max(maxScore, totalSum);
                totalSum += cardPoints[left];
                left++;
            }
            totalSum -= cardPoints[i];
        }
        return Math.max(maxScore, totalSum);
    }
}
