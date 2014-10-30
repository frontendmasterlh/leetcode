package leetcode_P;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        int carry = 0;
        int i = digits.length-1;
        digits[i] += 1;
        while (digits[i]>=10) {
            digits[i--] %= 10;
            if (i>=0){
                digits[i] += 1;
            }else {
                carry=1;
                break;
            }
        }
        if (carry==0)
            return digits;
        else {
            int[] res =new int[digits.length+1];
            res[0] = 1;
            for (int j=1; j < res.length; j++) {
                res[j] = digits[j-1];
            }
            return res;
        }
    }
	
	static public void main (String[] argv) {
		int[] num = {9,9,9,9,9,9,9};
		int[] res = new PlusOne().plusOne(num);
		for (int value: res)
			System.out.println(value);
	}
}
