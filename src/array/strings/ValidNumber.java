package array.strings;

/**
 * https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i <= j && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        if (i >= len) {
            return false;
        }
        while (i <= j && Character.isWhitespace(s.charAt(j))) {
            j--;
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        boolean digit = false;
        boolean dot = false;
        boolean exp = false;
        while (i <= j) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digit = true;
            } else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (c == 'e') {
                if (exp || !digit) return false;
                exp = true;
                digit = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return digit;
    }
}
