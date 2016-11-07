package array.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a ordered set of integers from 1 to 9. Combine them using + or - or nothing, such that the resulting equation sum is 100. 
 * Ex: 1 + 2 + 34 - 5 + 67 - 8 + 9 = 100; 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100;
 */
public class AddMinusOperatorResultingEquationSum {

    public List<String> getAllCombination(String nums, int sum) {
        List<String> res = new ArrayList<>();
        dfsHelper(nums, sum, 0, "", res);
        return res;
    }

    private void dfsHelper(String nums, int sum, int index, String temp, List<String> res) {
        if (index == nums.length() && sum == 0) {
            res.add(temp);
            return;
        }
        for (int i = index; i < nums.length(); i++) {
            String sub = nums.substring(index, i + 1);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                return;
            }
            int val  = Integer.parseInt(sub);
            if (temp.length() == 0) {
                dfsHelper(nums, sum - val, i + 1, sub, res);
            } else {
                // Add
                dfsHelper(nums, sum - val, i + 1, temp + "+" + sub, res);

                // Minus
                dfsHelper(nums, sum + val, i + 1, temp + "-" + sub, res);
            }
        }
    }

    public static void main(String[] args) {
        AddMinusOperatorResultingEquationSum a = new AddMinusOperatorResultingEquationSum();
        List<String> res = a.getAllCombination("12305", 4);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
