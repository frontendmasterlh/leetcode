package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> map  = new HashMap<>();
        int maxLen = 1;
        int slow = 0;
        int fast = 0;
        for (; fast < s.length(); fast++) {
            if (!map.containsKey(s.charAt(fast))) {
                map.put(s.charAt(fast), 1);
            } else {
                map.put(s.charAt(fast), map.get(s.charAt(fast)) + 1);
            }
            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, fast - slow + 1);
            } else {
                while (map.size() > 2) {
                    int count = map.get(s.charAt(slow));
                    if (count > 1) {
                        map.put(s.charAt(slow), count - 1);
                    } else if (count == 1) {
                        map.remove(s.charAt(slow));
                    }
                    slow++;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters l = new LongestSubstringWithAtMostTwoDistinctCharacters();
        System.out.println(l.lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(l.lengthOfLongestSubstringTwoDistinct("ee"));
        System.out.println(l.lengthOfLongestSubstringTwoDistinct("ececeecececececececececececeba"));

    }
}
