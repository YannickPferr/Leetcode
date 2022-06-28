package other.medium;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Problem: 1079. Letter Tile Possibilities
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsletter-tile-possibilities
 */
public class LetterTilePossibilities {
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