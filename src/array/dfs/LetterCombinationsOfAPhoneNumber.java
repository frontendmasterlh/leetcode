package array.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class LetterCombinationsOfAPhoneNumber {
    private String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfsHelper(digits, 0, sb, res);
        return res;
    }

    private void dfsHelper(String digits, int index, StringBuilder sb, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < letter[digits.charAt(index) - '0'].length(); i++) {
            char c = letter[digits.charAt(index) - '0'].charAt(i);
            sb.append(c);
            dfsHelper(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
