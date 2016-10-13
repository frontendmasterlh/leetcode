package array.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 */
public class PalindromePairs {
    // Time: O(k^2 * n) Space: O(n)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2Rev = new StringBuilder(str2).reverse().toString();
                    Integer idx = map.get(str2Rev);
                    if (idx != null && idx != i) {
                        res.add(Arrays.asList(idx, i));
                    }
                }
                if (isPalindrome(str2) && str2.length() != 0) {
                    String str1Rev = new StringBuilder(str1).reverse().toString();
                    Integer idx = map.get(str1Rev);
                    if (idx != null && idx != i) {
                        res.add(Arrays.asList(i, idx));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs palindromePairs = new PalindromePairs();
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> res = palindromePairs.palindromePairs(words);
        for (List<Integer> res1 : res) {
            for (Integer i : res1) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
