package array.hashtable;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // Sliding window  找最长的长度时刻更新maxLen,找最短的到最后再更新
    // Time: O(n) Space: O(k)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[] existed = new boolean[256];
        int maxLen = 1;
        int slow = 0;
        int fast = 0;
        for (; fast < s.length(); fast++) {
            if (!existed[s.charAt(fast)]) {
                existed[s.charAt(fast)] = true;
                maxLen = Math.max(maxLen, fast - slow + 1);
            } else {
                while (s.charAt(fast) != s.charAt(slow)) {
                    existed[s.charAt(slow)] = false;
                    slow++;
                }
                slow++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }
}
