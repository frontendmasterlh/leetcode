package array.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of words (without duplicates), find all word squares you can build from them.

 A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

 For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

 b a l l
 a r e a
 l e a d
 l a d y
 Note:

 There are at least 1 and at most 1000 words.
 All words will have the exact same length.
 Word length is at least 1 and at most 5.
 Each word contains only lowercase English alphabet a-z.


 Example 1:

 Input:
 ["area","lead","wall","lady","ball"]

 Output:
 [
 [ "wall",
 "area",
 "lead",
 "lady"
 ],
 [ "ball",
 "area",
 "lead",
 "lady"
 ]
 ]

 Explanation:
 The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).


 Example 2:

 Input:
 ["abat","baba","atan","atal"]

 Output:
 [
 [ "baba",
 "abat",
 "baba",
 "atan"
 ],
 [ "baba",
 "abat",
 "baba",
 "atal"
 ]
 ]

 Explanation:
 The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).


 Here's the reference: https://discuss.leetcode.com/topic/63516/explained-my-java-solution-using-trie-126ms-16-16/2
 */
public class WordSquare {
    public class TrieNode {
        List<String> startWith;
        TrieNode[] children;
        public TrieNode() {
            this.startWith = new ArrayList<>();
            this.children = new TrieNode[26];
        }
    }

    public class Trie {
        TrieNode root;

        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode cur = root;
                for (char c : word.toCharArray()) {
                    int idx = c - 'a';
                    if (cur.children[idx] == null) {
                        cur.children[idx] = new TrieNode();
                    }
                    cur.children[idx].startWith.add(word);
                    cur = cur.children[idx];
                }
            }
        }

        public List<String> findByPrefix(String prefix) {
            List<String> res = new ArrayList<>();
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    return res;
                }
                cur = cur.children[idx];
            }
            res.addAll(cur.startWith);
            return res;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int len = words.length;
        Trie trie = new Trie(words);
        List<String> temp = new ArrayList<>();
        for (String word : words) {
            temp.add(word);
            search(len, trie, temp, res);
            temp.remove(temp.size() - 1);
        }
        return res;
    }

    private void search(int len, Trie trie, List<String> temp, List<List<String>> res) {
        if (len == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        int idx = temp.size();
        StringBuilder sb = new StringBuilder();
        for (String str : temp) {
            sb.append(str.charAt(idx));
        }
        List<String> startWith = trie.findByPrefix(sb.toString());
        for (String sw : startWith) {
            temp.add(sw);
            search(len, trie, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
