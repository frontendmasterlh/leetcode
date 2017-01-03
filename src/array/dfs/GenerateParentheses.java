package array.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfsHelper(n, 0, 0, sb, res);
        return res;
    }

    private void dfsHelper(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (n == left && n == right) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            dfsHelper(n, left + 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(")");
            dfsHelper(n, left, right + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
