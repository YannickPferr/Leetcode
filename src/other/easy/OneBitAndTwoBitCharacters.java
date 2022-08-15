package other.easy;

/**
 * Problem: 717. 1-bit and 2-bit Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems1-bit-and-2-bit-characters
 */
public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int l = 0;
        while (l < bits.length) {
            if (l == bits.length - 1)
                return true;

            if (bits[l] == 1)
                l += 2;
            else
                l++;
        }
        return false;
    }
}