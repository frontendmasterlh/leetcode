package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        long res = num / den;
        sb.append(String.valueOf(res));
        if (num % den == 0) {
            return sb.toString();
        }

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        long reminder = num % den * 10;
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                int begin = map.get(reminder);
                String part1 = sb.toString().substring(0, begin);
                String part2 = sb.toString().substring(begin);
                return part1 + "(" + part2 + ")";
            }
            map.put(reminder, sb.length());
            long temp = reminder / den;
            sb.append(String.valueOf(temp));
            reminder = reminder % den * 10;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal f = new FractionToRecurringDecimal();
        System.out.println(f.fractionToDecimal(1, 5));
    }
}
