package array.strings;

/**
 * Created by jli1 on 11/1/16.
 */
public class Atoi {

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            num = num * 10 + (str.charAt(index) - '0');

            if (sign == 1 && num >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && num - 1 >= Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) num * sign;
        // if (num * sign >= Integer.MAX_VALUE) {
        //     return Integer.MAX_VALUE;
        // } else if (num * sign <= Integer.MIN_VALUE) {
        //     return Integer.MIN_VALUE;
        // } else {
        //     return (int) num * sign;
        // }
    }

    public static void main(String[] args) {
        Atoi a = new Atoi();
        System.out.println(a.myAtoi("-2147483648"));
    }
}
