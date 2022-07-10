package other.easy;

/**
 * Problem: 482. License Key Formatting
 * Difficulty: Easy
 * Link: https://leetcode.com/problemslicense-key-formatting
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = Character.toUpperCase(s.charAt(i));
            if (c != '-') {
                sb.append(c);
                count++;
                if (count % k == 0)
                    sb.append("-");
            }
        }
        sb.reverse();
        if (sb.length() > 0 && sb.charAt(0) == '-')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}