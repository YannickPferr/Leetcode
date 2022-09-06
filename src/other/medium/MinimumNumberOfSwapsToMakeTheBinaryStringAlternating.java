package other.medium;

/**
 * Problem: 1864. Minimum Number of Swaps to Make the Binary String Alternating
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsminimum-number-of-swaps-to-make-the-binary-string-alternating
 */
public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {
    public int minSwaps(String s) {
        int countMismatchedIdx1 = 0;
        char last = '1';
        int countOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                countOnes++;

            if (last != s.charAt(i))
                countMismatchedIdx1++;
            last = last == '1' ? '0' : '1';
        }
        int countZeros = s.length() - countOnes;
        if (Math.abs(countZeros - countOnes) > 1)
            return -1;

        int countMismatchedIdx2 = 0;
        last = '0';
        for (int i = 0; i < s.length(); i++) {
            if (last != s.charAt(i))
                countMismatchedIdx2++;
            last = last == '1' ? '0' : '1';
        }

        int min = 0;
        if (countMismatchedIdx1 % 2 != 0 && countMismatchedIdx2 % 2 != 0)
            return -1;
        if (countMismatchedIdx1 % 2 != 0)
            return countMismatchedIdx2 / 2;
        if (countMismatchedIdx2 % 2 != 0)
            return countMismatchedIdx1 / 2;
        return Math.min(countMismatchedIdx1, countMismatchedIdx2) / 2;
    }
}