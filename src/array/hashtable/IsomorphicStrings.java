package array.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {
    // Using only one hashmap is not enough. Need to keep track of all the value.
    // Time: O(n) Space: O(n)
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = map.get(s.charAt(i));
            if (c != null) {
                if (c != t.charAt(i)) {
                    return false;
                }
            } else {
                if (set.contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }

    public boolean isIsomorphicII(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings i = new IsomorphicStrings();
        System.out.println(i.isIsomorphic("egg", "add"));
        System.out.println(i.isIsomorphic("foo", "bar"));

        System.out.println(i.isIsomorphic("ab", "ca"));

        System.out.println(i.isIsomorphicII("egg", "add"));
        System.out.println(i.isIsomorphicII("foo", "bar"));
    }
}
