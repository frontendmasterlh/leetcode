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
}
