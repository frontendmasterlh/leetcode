package array.trie;

import java.util.*;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 */
public class WordSearchII {

    public class TrieNode {
        boolean isWord;
        String str;
        Map<Character, TrieNode> children;
        public TrieNode() {
            this.isWord = false;
            this.str = "";
            this.children = new HashMap<>();
        }
    }

    public class TrieTree {
        TrieNode root;
        public TrieTree(TrieNode root) {
            this.root = root;
        }

        public void insert(String str) {
            TrieNode cur = root;
            for (int i = 0; i < str.length(); i++) {
                if (!cur.children.containsKey(str.charAt(i))) {
                    cur.children.put(str.charAt(i), new TrieNode());
                }
                cur = cur.children.get(str.charAt(i));
            }
            cur.isWord = true;
            cur.str = str;
        }

        public boolean find(String str) {
            TrieNode cur = root;
            for (int i = 0; i < str.length(); i++) {
                if (!cur.children.containsKey(str.charAt(i))) {
                    return false;
                }
                cur = cur.children.get(str.charAt(i));
            }
            return cur.isWord;
        }
    }

    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        TrieTree trie = new TrieTree(new TrieNode());
        for (int i = 0; i < words.length; i++) { // Build the trie tree first, then find all the possible words.
            trie.insert(words[i]);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsHelper(board, trie.root, i, j, set);
            }
        }
        return new ArrayList<>(set);  // Use hash set to record the distinct words.
    }

    private void dfsHelper(char[][] board, TrieNode root, int x, int y, Set<String> set) {
        if (root.isWord) {
            if (!set.contains(root.str)) {
                set.add(root.str);
            }
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 0 || root == null) {
            return;
        }
        if (root.children.containsKey(board[x][y])) {
            char c = board[x][y];
            board[x][y] = 0;  // Set the board[x][y] as visited.
            for (int k = 0; k < 4; k++) {
                int i = x + direction[k][0];
                int j = y + direction[k][1];
                dfsHelper(board, root.children.get(c), i, j, set);
            }
            board[x][y] = c;
        }
    }
}
