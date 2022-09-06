package other.medium;

/**
 * Problem: 208. Implement Trie (Prefix Tree)
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsimplement-trie-prefix-tree
 */
class Trie {

    class TrieNode {
        TrieNode[] children;
        char val;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = parent.children[word.charAt(i) - 'a'];
            if (node == null)
                node = new TrieNode(word.charAt(i));
            parent.children[word.charAt(i) - 'a'] = node;
            node.isEnd = node.isEnd || i == word.length() - 1;
            parent = node;
        }
    }

    public boolean search(String word) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = parent.children[word.charAt(i) - 'a'];
            if (node == null)
                return false;
            parent = node;
        }
        return parent.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode parent = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode node = parent.children[prefix.charAt(i) - 'a'];
            if (node == null)
                return false;
            parent = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */