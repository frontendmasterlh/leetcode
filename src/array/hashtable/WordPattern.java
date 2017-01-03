package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {
    //Time: O(n), Space: O(n)
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }
        if (str == null || pattern == null) {
            return false;
        }

        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> stringMap = new HashMap<>();
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (!charMap.containsKey(pattern.charAt(i))) {
                charMap.put(pattern.charAt(i), strArray[i]);
            }
            if (!stringMap.containsKey(strArray[i])) {
                stringMap.put(strArray[i], pattern.charAt(i));
            }
            if (!charMap.get(pattern.charAt(i)).equals(strArray[i])
                || !stringMap.get(strArray[i]).equals(pattern.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern.wordPattern(pattern, str));
    }
}
