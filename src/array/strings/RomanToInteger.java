package array.strings;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    private int tran (char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = tran(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (tran(s.charAt(i - 1)) < tran(s.charAt(i))) {
                res += tran(s.charAt(i)) - 2 * tran(s.charAt(i - 1));
            } else {
                res += tran(s.charAt(i));
            }
        }
        return res;
    }
}
