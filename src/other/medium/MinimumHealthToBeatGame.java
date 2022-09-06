package other.medium;

/**
 * Problem: 2214. Minimum Health to Beat Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-health-to-beat-game
 */
public class MinimumHealthToBeatGame {
    public long minimumHealth(int[] damage, int armor) {
        long maxDmg = 0;
        long totalDmg = 0;
        for (int dmg : damage) {
            totalDmg += dmg;
            maxDmg = Math.max(maxDmg, dmg);
        }
        return totalDmg - Math.min(armor, maxDmg) + 1;
    }
}