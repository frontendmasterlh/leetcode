package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        if (s == null || s.length() == 0) {
            return t.charAt(0);
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) {
                return t.charAt(i);
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        return '\0';
    }

    public char findTheDifferenceBit(String s, String t) {
        char c = '\0';
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            c ^= t.charAt(i);
        }
        return c;
    }

    public char findTheDifferenceArray(String s, String t) {
         int[] mem = new int[26];
         for (int i = 0; i < s.length(); i++) {
             mem[s.charAt(i) - 'a']++;
         }
         char res = '\0';
         for (int j = 0; j < t.length(); j++) {
             mem[t.charAt(j) - 'a']--;
             if (mem[t.charAt(j) - 'a'] < 0) {
                 res = t.charAt(j);
                 break;
             }
         }
         return res;
    }

    public static void main(String[] args) {
        FindTheDifference f = new FindTheDifference();
        System.out.println(f.findTheDifference("abcd", "abcde"));
    }
}
