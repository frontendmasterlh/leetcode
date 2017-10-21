package array.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Set<String>> visited = new HashMap<>();
        Map<String, Integer> level = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return res;
        }
        int len = Integer.MAX_VALUE;
        visited.put(beginWord, new HashSet<>());
        level.put(beginWord, 1);
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String str = queue.poll();
            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder(str);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String newStr = sb.toString();
                    if (wordList.contains(newStr) && !level.containsKey(newStr) ||
                        level.containsKey(newStr) && level.get(newStr) > level.get(str)) {
                        if (visited.containsKey(newStr)) {
                            visited.get(newStr).add(str);
                        } else {
                            Set<String> path = new HashSet<>();
                            path.add(str);
                            visited.put(newStr, path);
                            level.put(newStr, level.get(str) + 1);
                            queue.offer(newStr);
                        }
                    }
                    if (newStr.equals(endWord)) { //Because it can be found more than once.
                        if (level.get(str) < len) { // Use level to find the shortest path. Note: str here
                            List<String> list = new ArrayList<>();
                            list.add(endWord);
                            res.addAll(backTrace(visited, str, list));
                            len = level.get(str) + 1;
                        } else {
                            break; //The path should be longer than the previous one.
                        }
                    }
                }
            }
        }
        return res;
    }

    private List<List<String>> backTrace(Map<String, Set<String>> visited, String endWord, List<String> list) {
        List<List<String>> res = new ArrayList<>();
        List<String> entry = new ArrayList<>(list);
        entry.add(0, endWord);
        if (visited.get(endWord).size() < 1) {
            res.add(entry);
            return res;
        }
        for (String str : visited.get(endWord)) {
            res.addAll(backTrace(visited, str, entry));
        }
        return res;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, Set<String>> visited = new HashMap<>();
        Map<String, Integer> level = new HashMap<>();
        int len = Integer.MAX_VALUE;
        Set<String> dict = new HashSet<>(wordList);

        queue.offer(beginWord);
        level.put(beginWord, 1);
        visited.put(beginWord, new HashSet<>());

        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char j = 'a'; j <= 'z'; j++) {
                    sb.setCharAt(i, j);
                    String newStr = sb.toString();
                    if (dict.contains(newStr) && (!level.containsKey(newStr) ||
                            level.containsKey(newStr) && level.get(newStr) > level.get(word))) {
                        Set<String> fromSet = visited.get(newStr);
                        if (fromSet == null) {
                            fromSet = new HashSet<>();
                            visited.put(newStr, fromSet);
                            queue.offer(newStr);
                        }
                        fromSet.add(word);
                        level.put(newStr, level.get(word) + 1);

                        if (endWord.equals(newStr)) { //Because it can be found more than once.
                            if (level.get(word) <= len) { // Use level to find the shortest path. Note: word here
                                List<String> list = new ArrayList<>();
                                list.add(endWord);
                                res.addAll(backTrace(list, word, visited));
                                len = level.get(word);
                            } else {
                                break; // Path should be longer than the previous one.
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private List<List<String>> backTrace(List<String> list, String word, Map<String, Set<String>> visited) {
        List<List<String>> res = new ArrayList<>();
        List<String> entry = new ArrayList<>(list);
        entry.add(0, word);
        if (visited.get(word).isEmpty()) {
            res.add(entry);
            return res;
        }
        for (String str : visited.get(word)) {
            res.addAll(backTrace(entry, str, visited));
        }
        return res;
    }

    public static void main(String[] agrs) {
        WordLadderII w = new WordLadderII();
        List<String> wordList = new ArrayList<>();
        String[] str = {"ted","tex","red","tax","tad","den","rex","pee"};
        for (String s : str) {
            wordList.add(s);
        }
        List<List<String>> res = w.findLadders("red", "tax", wordList);
        for (List<String> list : res) {
            for (String word : list) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
