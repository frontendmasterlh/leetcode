package array.dfs;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if ((s == null && p == null) || (s.length() == 0 && p.length() == 0)) {
            return true;
        }
        if (s.length() == 0) {
            return checkEmpty(p);
        }
        if (p.length() == 0) { // Now s's length cannot be 0.
            return false;
        }
        char c1 = s.charAt(0);
        char d1 = p.charAt(0);
        char d2 = '\0';
        if (p.length() > 1) {
            d2 = p.charAt(1);
        }
        if (d2 == '*') {
            if (compare(c1, d1)) { // It could match 0 or more (2 cases).
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2)); // ignore the * sign
            }
        } else {
            if (compare(c1, d1)) {                 // perfectly match
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }

    private boolean compare(char c1, char c2) {
        return c1 == c2 || c2 == '.';
    }

    private boolean checkEmpty(String p) {
        if (p.length() % 2 != 0) { //  * sign have to pair with another char
            return false;
        }
        for (int i = 1; i < p.length(); i += 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch("aa", "a"));
    }
}
