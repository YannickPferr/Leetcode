package other.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 1268. Search Suggestions System
 * Difficulty: Medium
 * Link: https://leetcode.com/problemssearch-suggestions-system
 */
public class SearchSuggestionsSystem {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        char val;
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode prev = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode node = prev.children[word.charAt(i) - 'a'];
                if (node == null)
                    node = new TrieNode();
                node.val = word.charAt(i);
                node.isEndOfWord = node.isEndOfWord || i == word.length() - 1;
                prev.children[word.charAt(i) - 'a'] = node;
                prev = node;
            }
        }

        public List<String> search(String word) {
            List<String> words = new ArrayList<>();
            TrieNode prev = root;
            for (int i = 0; i < word.length(); i++) {
                prev = prev.children[word.charAt(i) - 'a'];
                if (prev == null)
                    return words;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            backtracking(words, prev, sb);
            return words;
        }
    }

    public void backtracking(List<String> l, TrieNode curr, StringBuilder sb) {
        if (l.size() == 3)
            return;
        if (curr.isEndOfWord)
            l.add(sb.toString());

        for (int i = 0; i < 26; i++)
            if (curr.children[i] != null) {
                sb.append((char) (i + 'a'));
                backtracking(l, curr.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products)
            trie.insert(product);
        List<List<String>> l = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++)
            l.add(trie.search(searchWord.substring(0, i + 1)));
        return l;
    }
}