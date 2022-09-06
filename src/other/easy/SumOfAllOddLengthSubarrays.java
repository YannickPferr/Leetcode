package other.easy;

/**
 * Problem: 1588. Sum of All Odd Length Subarrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problemssum-of-all-odd-length-subarrays
 */
public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++)
            prefix[i] = arr[i] + prefix[i - 1];

        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j >= 0; j -= 2)
                sum += prefix[i] - (j - 1 >= 0 ? prefix[j - 1] : 0);
        return sum;
    }
}