package other.easy;

/**
 * Problem: 345. Reverse Vowels of a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-vowels-of-a-string
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] charArr = s.toCharArray();
        while (l < r) {
            char a = charArr[l];
            char b = charArr[r];
            if (isVowel(a) && isVowel(b)) {
                swap(charArr, l, r);
                l++;
                r--;
            } else if (isVowel(a) && !isVowel(b))
                r--;
            else
                l++;
        }

        return new String(charArr);
    }

    public boolean isVowel(char c) {
        char temp = Character.toLowerCase(c);
        if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')
            return true;

        return false;
    }

    public void swap(char[] charArr, int l, int r) {
        char temp = charArr[l];
        charArr[l] = charArr[r];
        charArr[r] = temp;
    }
}