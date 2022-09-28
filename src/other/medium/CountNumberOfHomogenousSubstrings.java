package other.medium;

/**
 * Problem: 1759. Count Number of Homogenous Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscount-number-of-homogenous-substrings
 */
public class CountNumberOfHomogenousSubstrings {
    public int countHomogenous(String s) {
        int mod = (int) Math.pow(10, 9) + 7;
        long count = 0;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                long n = i - start;
                count += n * (n + 1) / 2;
                start = i;
            }
        }
        long n = s.length() - start;
        count += n * (n + 1) / 2;

        return (int) (count % mod);
    }
}