package other.easy;

/**
 * Problem: 13. Roman to Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/roman-to-integer
 */
public class RomanToInteger {
    public int romanToInt(String s) {

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {

            int num = 0;
            char c = s.charAt(i);
            if (i + 1 < s.length()) {
                i++;
                char next = s.charAt(i);
                if (c == 'I' && next == 'V')
                    num = 4;
                else if (c == 'I' && next == 'X')
                    num = 9;
                else if (c == 'X' && next == 'L')
                    num = 40;
                else if (c == 'X' && next == 'C')
                    num = 90;
                else if (c == 'C' && next == 'D')
                    num = 400;
                else if (c == 'C' && next == 'M')
                    num = 900;

                if (num != 0) {
                    sum += num;
                    continue;
                } else
                    i--;
            }

            num = charToInt(c);
            sum += num;
        }

        return sum;
    }

    public int charToInt(char c) {
        if (c == 'I')
            return 1;
        else if (c == 'V')
            return 5;
        else if (c == 'X')
            return 10;
        else if (c == 'L')
            return 50;
        else if (c == 'C')
            return 100;
        else if (c == 'D')
            return 500;
        else if (c == 'M')
            return 1000;

        return 0;
    }
}