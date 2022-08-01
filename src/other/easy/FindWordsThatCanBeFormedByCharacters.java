package other.easy;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Problem: 1160. Find Words That Can Be Formed by Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-words-that-can-be-formed-by-characters
 */
public class FindWordsThatCanBeFormedByCharacters {
    HashSet<LinkedList<Character>> hs = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        backtracking(tiles, new HashSet<>(), new LinkedList<>());
        return hs.size();
    }

    public void backtracking(String tiles, HashSet<Integer> seen, LinkedList<Character> l) {
        if (!l.isEmpty())
            hs.add(new LinkedList<>(l));
        for (int i = 0; i < tiles.length(); i++) {
            if (seen.contains(i))
                continue;
            l.add(tiles.charAt(i));
            seen.add(i);
            backtracking(tiles, seen, l);
            seen.remove(i);
            l.removeLast();
        }
    }
}