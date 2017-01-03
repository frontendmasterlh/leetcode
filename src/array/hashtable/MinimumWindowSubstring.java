package array.hashtable;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    // Maintain 2 pointers. One for finding all the required chars and the other for minimize the result
    // Time: O(n) Space: O(n)
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        int[] count = new int[256];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }
        int begin = -1;
        int windowLen = s.length() + 1; // initialize the len that are larger than the string s
        int start = 0;
        int remain = t.length();
        for (int i = 0; i < s.length(); i++) {
            if (--count[s.charAt(i)] >= 0) {
                if (--remain == 0) {
                    while (++count[s.charAt(start)] <= 0) { // Minimize the result
                        start++;
                    }
                    int len = i - start + 1;
                    if (len < windowLen) {
                        begin = start;
                        windowLen = len;
                    }
                    remain++;
                    start++; // Do not use start again
                }
            }
        }
        return begin == -1 ? "" : s.substring(begin, begin + windowLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
    }
}
