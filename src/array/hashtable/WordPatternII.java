package array.hashtable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

 Examples: pattern = "abab", str = "redblueredblue" should return true. pattern = "aaaa", str = "asdasdasdasd" should return true.
 pattern = "aabb", str = "xyzabcxzyabc" should return false. Notes: You may assume both pattern and str contains only lowercase letters.
 */
public class WordPatternII {

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }
        if (pattern == null || str == null) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        boolean[] res = new boolean[1];

        dfsHelper(pattern, str, 0, 0, map, set, res);
        return res[0];
    }

    private void dfsHelper(String pattern, String str, int i, int j, Map<Character, String> map, Set<String> set, boolean[] res) {
        if (i == pattern.length() && j == str.length()) {
            res[0] = true;
            return;
        }
        if (i >= pattern.length() || j >= str.length()) {
            return;
        }

        char c = pattern.charAt(i);
        for (int cut = j + 1; cut <= str.length(); cut++) { // Note: <=
            String subStr = str.substring(j, cut);
            if (!map.containsKey(c) && !set.contains(subStr)) {
                map.put(c, subStr);
                set.add(subStr);
                dfsHelper(pattern, str, i + 1, cut, map, set, res);
                set.remove(subStr);
                map.remove(c, subStr);
            } else if (map.containsKey(c) && set.contains(subStr)) {
                dfsHelper(pattern, str, i + 1, cut, map, set, res);
            }
        }
    }

    public static void main(String[] args) {
        WordPatternII wordPatternII = new WordPatternII();
        String pattern = "abab";
        String str = "redblueredblue";

        System.out.println(wordPatternII.wordPatternMatch(pattern, str));
    }
}
