package array.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expression-add-operators/
 */
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dfsHelper(num, target, "", 0, 0, res);
        return res;
    }

    private void dfsHelper(String num, int target, String temp, long curRes, long preNum, List<String> res) {
        if (num.length() == 0 && target == curRes) {
            res.add(new String(temp));
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String curStr = num.substring(0, i);
            if (curStr.length() > 1 && curStr.charAt(0) == '0') {
                return;
            }
            long curNum = Long.parseLong(curStr);
            String next = num.substring(i);
            if (temp.length() != 0) { // If it's the first num, then just add digit; else add operator
                // Multiple
                dfsHelper(next, target, temp + "*" + curNum, (curRes - preNum) + preNum * curNum, preNum * curNum, res);

                // Add
                dfsHelper(next, target, temp + "+" + curNum, curRes + curNum, curNum, res);

                // Minus
                dfsHelper(next, target, temp + "-" + curNum, curRes - curNum, -curNum, res);

            } else {
                dfsHelper(next, target, curStr, curNum, curNum, res);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators e = new ExpressionAddOperators();
        List<String> res = e.addOperators("12305", 15);
        for (String str : res) {
            System.out.println(str);
        }
    }

}
