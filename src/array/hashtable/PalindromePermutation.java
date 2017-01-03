package array.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example, "code" -> False, "aab" -> True, "carerac" -> True.

 Hint:

 Consider the palindromes of odd vs even length.
 What difference do you notice? Count the frequency of each character.
 If each character occurs even number of times, then it must be a palindrome.
 How about character which occurs odd number of times?
 */
public class PalindromePermutation {
    // Time: O(n) Space: O(n)
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutation p = new PalindromePermutation();
        System.out.println(p.canPermutePalindrome("aab"));
        System.out.println(p.canPermutePalindrome("carerac"));
    }
}
