package array.maths;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = 0 - x;
        }
        int res = 0;
        while (x > 0) {
            int temp = res * 10 + x % 10;
            x /= 10;
            if (temp / 10 != res) { // it might overflow.
                res = 0;
                break;
            }
            res = temp;
        }
        return neg ? -res : res;
    }
}
