package array.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        int[] hash = new int[256];
        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while(right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }
            if (count == 0) {
                res.add(left);
            }
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return res;
    }
}
