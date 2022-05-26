package math.easy;

/**
 * Problem: 66. Plus One
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/plus-one
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        int carry = 1;
        for (int r = digits.length - 1; carry == 1 && r >= 0; r--) {
            if (digits[r] == 9) {
                digits[r] = 0;
                carry = 1;
            } else {
                digits[r]++;
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] arr = new int[digits.length + 1];
            arr[0] = carry;
            for (int i = 1; i < arr.length; i++)
                arr[i] = digits[i - 1];
            digits = arr;
        }

        return digits;
    }
}