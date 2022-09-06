package other.medium;

/**
 * Problem: 211. Design Add and Search Words Data Structure
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdesign-add-and-search-words-data-structure
 */
class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        char val;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode(char c) {
            val = c;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode prev = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = prev.children[word.charAt(i) - 'a'];
            if (node == null)
                node = new TrieNode(word.charAt(i));
            node.isEndOfWord = node.isEndOfWord || i == word.length() - 1;
            prev.children[word.charAt(i) - 'a'] = node;
            prev = node;
        }
    }

    public boolean search(String word) {
        return rec(root, word, 0);
    }

    public boolean rec(TrieNode node, String word, int pos) {
        if (node == null)
            return false;
        if (pos == word.length())
            return node.isEndOfWord;

        char c = word.charAt(pos);
        if (c != '.')
            return rec(node.children[c - 'a'], word, pos + 1);

        for (int i = 0; i < 26; i++)
            if (rec(node.children[i], word, pos + 1))
                return true;

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */