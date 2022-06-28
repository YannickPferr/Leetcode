package other.easy;

/**
 * Problem: 292. Nim Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsnim-game
 */
public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}