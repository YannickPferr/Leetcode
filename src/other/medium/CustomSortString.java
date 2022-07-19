package other.medium;

/**
 * Problem: 791. Custom Sort String
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscustom-sort-string
 */
public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            if (count[order.charAt(i) - 'a'] >= 0) {
                for (int j = 0; j < count[order.charAt(i) - 'a']; j++)
                    sb.append(order.charAt(i));
                count[order.charAt(i) - 'a'] = 0;
            }
        }

        for (int i = 0; i < 26; i++)
            while (count[i]-- > 0)
                sb.append((char) (i + 'a'));

        return sb.toString();
    }
}