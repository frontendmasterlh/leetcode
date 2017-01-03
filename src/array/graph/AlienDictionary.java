package array.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.

 For example, Given the following words in dictionary,

 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 The correct order is: "wertf".

 * Note: You may assume all letters are in lowercase. If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> seq = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();

        // Initialize
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                Set<Character> set = seq.get(word.charAt(i));
                if (set == null) {
                    seq.put(word.charAt(i), new HashSet<>());
                }
                Integer indegree = indegrees.get(word.charAt(i));
                if (indegree == null) {
                    indegrees.put(word.charAt(i), 0);
                }
            }
        }

        // Record indegrees
        Set<String> edges = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                char from = word1.charAt(j);
                char to = word2.charAt(j);
                if (from == to) {
                    continue;
                }
                if (!edges.contains(from + "" + to)) {
                    Set<Character> set = seq.get(from);
                    set.add(to);
                    Integer indegree = indegrees.get(to);
                    indegree++;
                    indegrees.put(to, indegree);
                    edges.add(from + "" + to);
                    break; // Only the first different char makes sense
                }
            }
        }

        // Topological sort
        Queue<Character> q = new LinkedList<>();
        for (Character c : indegrees.keySet()) {
            if (indegrees.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            Character cur = q.poll();
            Set<Character> set = seq.get(cur);
            for (Character next : set) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) {
                    q.offer(next);
                }
            }
            sb.append(cur);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AlienDictionary a = new AlienDictionary();
        String[] words = {"wrt",
                          "wrf",
                          "er",
                          "ett",
                          "rftt"};
        System.out.println(a.alienOrder(words));
    }
}
