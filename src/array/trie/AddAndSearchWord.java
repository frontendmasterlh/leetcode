package array.trie;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class AddAndSearchWord {
    public class TrieNode {
        boolean hasWord;
        TrieNode[] children;
        public TrieNode () {
            this.children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
            this.hasWord = false;
        }
    }

    TrieNode root;

    public AddAndSearchWord(){
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        char[] arr = word.toCharArray();
        TrieNode now = root;
        for(int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }
        now.hasWord = true;
    }

    boolean find(char[] arr, int index, TrieNode now) {
        if(index == arr.length) {
            return now.hasWord;
        }

        Character c = arr[index];
        if (c == '.') {
            for(int i = 0; i < 26; ++i)
                if (now.children[i] != null) {
                    if (find(arr, index+1, now.children[i]))
                        return true;
                }
            return false;
        } else if (now.children[c - 'a'] != null) {
            return find(arr, index+1, now.children[c - 'a']);
        } else {
            return false;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        char[] arr = word.toCharArray();
        return find(arr, 0, root);
    }
}
