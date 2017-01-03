package array.trie;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */

class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] children;
    public TrieNode() {
        this.children = new TrieNode[26];
        for (TrieNode child : this.children) {
            child = null;
        }
        this.isWord = false;
    }
}

public class ImplementTriePrefixTree {
    private TrieNode root;

    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        if (cur.isWord == true) {
            return true;
        }
        for (TrieNode child : cur.children) {
            if(child != null) {
                return true;
            }
        }
        return false;
    }
}
