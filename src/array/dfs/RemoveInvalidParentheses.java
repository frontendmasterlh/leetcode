package array.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        // // DFS
        // List<String> res = new ArrayList<>();
        // if (s == null) {
        //     res.add("");
        //     return res;
        // }
        // int[] min = {Integer.MAX_VALUE};
        // dfsHelper(s, 0, 0, "", min, res);
        // if (res.size() == 0) {
        //     res.add("");
        // }
        // return res;

        // BFS
        List<String> res = new ArrayList<>();
        if (s == null) {
            res.add("");
            return res;
        }
        boolean found = false;
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        set.add(s);
        while (!q.isEmpty()) {
            s = q.poll();
            if (isValid(s)) {
                res.add(s);
                found = true;
            }
            if (found) {
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                if (!isParentheses(s.charAt(i))) {
                    continue;
                }
                String t = s.substring(0, i) + s.substring(i + 1);
                if (!set.contains(t)) {
                    q.offer(t);
                    set.add(t);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    private boolean isParentheses(char c) {
        return c == '(' || c == ')';
    }

    private void dfsHelper(String s, int remove, int count, String str, int[] min, List<String> res) {
        if (s.length() == 0) {
            if (count == 0 && str.length() != 0) {
                if (remove < min[0]) {
                    res.clear();
                    min[0] = remove;
                }
                if (remove == min[0] && !res.contains(str)) {
                    res.add(str);
                }
            }
            return;
        }

        if (s.charAt(0) == '(') {
            dfsHelper(s.substring(1), remove, count + 1, str + '(', min, res);
            dfsHelper(s.substring(1), remove + 1, count, str, min, res);
        } else if (s.charAt(0) == ')') {
            if (count > 0) {
                dfsHelper(s.substring(1), remove, count - 1, str + ')', min, res);
            }
            dfsHelper(s.substring(1), remove + 1, count, str, min, res);
        } else {
            dfsHelper(s.substring(1), remove, count, str + s.charAt(0), min, res);
        }
    }
}
