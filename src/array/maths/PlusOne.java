package array.maths;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        int i = digits.length - 1;
        digits[i] += 1;
        while (digits[i] >= 10) {
            digits[i] %= 10;
            i--;
            if (i >= 0) {
                digits[i] += 1;
            } else {
                carry = 1;
                break;
            }
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            System.arraycopy(digits, 0, temp, 1, temp.length - 1);
            return temp;
        }
    }
}
