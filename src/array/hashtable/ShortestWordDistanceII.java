package array.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *This is a follow up of Shortest Word Distance.
 * The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters.
 * How would you optimize it?

 Design a class which receives a list of words in the constructor,
 and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

 For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.

 Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * */
public class ShortestWordDistanceII {
    Map<String, List<Integer>> map = new HashMap<>();

    // Time: O(n) Space: O(n)
    public ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i]) == null) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> idx1 = map.get(word1);
        List<Integer> idx2 = map.get(word2);
        int distance = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < idx1.size() && j < idx2.size()) {
            distance = Math.min(distance, Math.abs(idx1.get(i) - idx2.get(j)));
            if (idx1.get(i) > idx2.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistanceII shortestWordDistanceII = new ShortestWordDistanceII(words);
        System.out.println(shortestWordDistanceII.shortest("perfect", "makes"));
    }

}
