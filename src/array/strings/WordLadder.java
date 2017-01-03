package array.strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        int len = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);

        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (int j = 0; j < str.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        StringBuilder sb = new StringBuilder(str);
                        sb.setCharAt(j, c);
                        String newStr = sb.toString();
                        if (wordList.contains(newStr) && !set.contains(newStr)) {
                            if (newStr.equals(endWord)) {
                                return len;
                            } else {
                                set.add(newStr);
                                queue.offer(newStr);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
