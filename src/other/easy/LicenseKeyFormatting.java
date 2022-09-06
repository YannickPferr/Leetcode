package other.easy;

/**
 * Problem: 482. License Key Formatting
 * Difficulty: Easy
 * Link: https://leetcode.com/problemslicense-key-formatting
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        String output = "";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = Character.toUpperCase(s.charAt(i));
            if (sb.length() == k && c != '-') {
                output = sb.reverse().toString() + (output.length() == 0 ? "" : "-" + output);
                sb = new StringBuilder();
            }

            if (c == '-')
                continue;
            else
                sb.append(c);
        }
        output = sb.reverse().toString() + (output.length() == 0 ? "" : "-" + output);
        return output;
    }
}