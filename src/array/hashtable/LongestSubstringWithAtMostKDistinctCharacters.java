package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) {
            return 0;
        }
        if (s.length() < k) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 1;
        int slow = 0;
        int fast = 0;
        for (; fast < s.length(); fast++) {
            if (map.containsKey(s.charAt(fast))) {
                map.put(s.charAt(fast), map.get(s.charAt(fast)) + 1);
            } else {
                map.put(s.charAt(fast), 1);
            }
            if (map.size() <= k) {
                maxLen = Math.max(maxLen, fast - slow + 1);
            } else  {
                while (map.size() > k) {
                    Integer count = map.get(s.charAt(slow));
                    if (count > 1) {
                        map.put(s.charAt(slow), count - 1);
                    } else if (count == 1){
                        map.remove(s.charAt(slow));
                    }
                    slow++;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters l = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(l.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(l.lengthOfLongestSubstringKDistinct("ee", 5));
        System.out.println(l.lengthOfLongestSubstringKDistinct("ececeecececececececececececeba", 3));
    }
}
