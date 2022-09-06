package other.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem: 1160. Find Words That Can Be Formed by Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-words-that-can-be-formed-by-characters
 */
public class FindWordsThatCanBeFormedByCharacters {
    int count = 0;
    HashSet<Integer> visited = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        rec(arr, 0);
        return count;
    }

    public void rec(char[] tiles, int pos) {
        if (pos > 0)
            count++;

        if (pos < tiles.length)
            for (int i = 0; i < tiles.length; i++) {
                if (visited.contains(i))
                    continue;
                if (i - 1 >= 0 && tiles[i - 1] == tiles[i] && !visited.contains(i - 1))
                    continue;

                visited.add(i);
                rec(tiles, pos + 1);
                visited.remove(i);
            }
    }
}