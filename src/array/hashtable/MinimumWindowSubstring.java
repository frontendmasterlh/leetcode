package array.hashtable;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * https://leetcode.com/problems/minimum-window-substring/discuss/
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

    public String minWindow_2(String s, String t) {
        int[] map = new int[256];
        int counter = t.length();
        int begin = 0, end = 0;
        int head = -1;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                counter--;
            }
            while (counter == 0) {
                if (end - begin < len) {  // end has already added 1 in line 12.
                    head = begin;
                    len = end - begin;
                }
                if (map[s.charAt(begin++)]++ == 0) {
                    counter++;
                }
            }
        }
        return head == -1 ? "" : s.substring(head, head + len);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
//        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(m.minWindow_2("a", "a"));
    }
}
