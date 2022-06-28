package other.easy;

/**
 * Problem: 1071. Greatest Common Divisor of Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsgreatest-common-divisor-of-strings
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.charAt(0) != str2.charAt(0))
            return "";

        String longerString = "";
        String shorterString = "";
        if (str1.length() < str2.length()) {
            longerString = str2;
            shorterString = str1;
        } else {
            longerString = str1;
            shorterString = str2;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(shorterString);
        while (sb.length() > 0 && (!fits(sb.toString(), shorterString) || !fits(sb.toString(), longerString)))
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public boolean fits(String s1, String s2) {
        if (s2.length() % s1.length() != 0)
            return false;

        for (int i = 0; i < s2.length(); i++) {
            int j = i % s1.length();
            if (s2.charAt(i) != s1.charAt(j))
                return false;
        }

        return true;
    }
}