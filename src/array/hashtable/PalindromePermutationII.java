package array.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

 For example:

 Given s = "aabb", return ["abba", "baab"].

 Given s = "abc", return [].

 Hint:

 If a palindromic permutation exists, we just need to generate the first half of the string.
 To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
 */
public class PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        // Step1: determine whether it can generate a palindrome string
        Map<Character, Integer> map = new HashMap<>();
        if (!canGeneratePalindrome(map, s)) {
            return res;
        }

        // Step2: Generate the first half of the string
        StringBuilder sb = new StringBuilder();
        char middle = '\0';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            while (value  > 1) {
                sb.append(key);
                value -= 2;
            }
            if (value == 1) {
                middle = key;
            }
        }

        // Step3: generate the permutation of the string
        permutation(sb.toString().toCharArray(), 0, res);

        // Step4: append the second half of the string
        List<String> res2 = new ArrayList<>();
        for (String str : res) {
            StringBuilder temp = new StringBuilder(str);

            if (middle != '\0') {
                temp.append(middle);
            }
            for (int i = str.length() - 1; i >= 0; i--) {
                temp.append(str.charAt(i));
            }
            res2.add(temp.toString());
        }
        return res2;
    }

    private boolean canGeneratePalindrome(Map<Character, Integer> map, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                count++;
            }
        }
        return count <= 1;
    }

    private void permutation(char[] s, int index, List<String> res) {
        if (index == s.length) {
            res.add(new String(s));
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (!containDuplicate(s, index, i)) {
                swap(s, i, index);
                permutation(s, index + 1, res);
                swap(s, i, index);
            }
        }
    }

    private boolean containDuplicate(char[] s, int i, int j) {
        for (int k = i; k < j; k++) {
            if (s[k] == s[j]) {
                return true;
            }
        }
        return false;
    }

    private void swap(char[] s, int i, int j) {
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }

    public static void main(String[] args) {
        PalindromePermutationII p = new PalindromePermutationII();
        List<String> res = p.generatePalindromes("aabb");
        for (String str : res) {
            System.out.println(str);
        }

        List<String> res2 = p.generatePalindromes("abc");
        for (String str : res2) {
            System.out.println(str);
        }
    }
}
