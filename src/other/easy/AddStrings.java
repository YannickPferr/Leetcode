package other.easy;

/**
 * Problem: 415. Add Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsadd-strings
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int l = num1.length() - 1;
        int r = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l >= 0 || r >= 0) {
            int n1 = l >= 0 ? Character.getNumericValue(num1.charAt(l)) : 0;
            int n2 = r >= 0 ? Character.getNumericValue(num2.charAt(r)) : 0;
            int newDigit = n1 + n2 + carry;
            carry = newDigit >= 10 ? 1 : 0;
            sb.append(newDigit % 10);
            l--;
            r--;
        }
        if (carry > 0)
            sb.append(carry);

        return sb.reverse().toString();
    }
}