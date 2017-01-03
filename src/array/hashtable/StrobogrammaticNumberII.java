package array.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Find all strobogrammatic numbers that are of length = n.

 For example, Given n = 2, return ["11","69","88","96"].
 */
public class StrobogrammaticNumberII {

    // Time: O(5 ^ (n/2)) Space: O(n)
    public List<String> findStrobogrammatic(int n) {
        int[] dict = {0, 1, 6, 8, 9};
        List<String> res = new ArrayList<>();
        buildString(dict, n, "", res);
        return res;
    }

    private void buildString(int[] dict, int n, String str, List<String> res) {
        if (str.length() == n) {
            res.add(str);
            return;
        }
        boolean last = str.length() + 1 == n; //Check if only 1 position left
        for (int c : dict) {
            if ((str.length() == 0 && c == 0) || (last && (c == 6 || c == 9))) {
                continue;
            }
            StringBuilder sb = new StringBuilder(str);
            addNum(sb, c, last);
            buildString(dict, n, sb.toString(), res);
        }
    }

    private void addNum(StringBuilder sb, int c, boolean last) {
        if (c == 6) {
            sb.insert(sb.length() / 2, 69);
        } else if (c == 9) {
            sb.insert(sb.length() / 2, 96);
        } else {
            sb.insert(sb.length() / 2, last ? c : "" + c + c);
        }
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII strobogrammaticNumberII = new StrobogrammaticNumberII();
        List<String> res = strobogrammaticNumberII.findStrobogrammatic(2);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
