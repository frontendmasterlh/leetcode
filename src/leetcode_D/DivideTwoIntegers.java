package leetcode_D;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor==0 || divisor==1)
            return dividend;
        long divd = dividend;
        long divs = divisor;
        boolean flag = true;
        if (dividend < 0){
            divd = -divd;
            flag = !flag;
        }
        if (divisor < 0) {
            divs = -divs;
            flag = !flag;
        }
        long[] f = new long[32];
        for (int i = 0; i< 32; i++) {
            f[i] = divs << i;
        }
        
        int res = 0;
        for (int i = 31; i >= 0 ; i--){
            if (divd >= f[i]){
                divd -= f[i];
                res += 1 <<i;
            }
        }
        if (flag== false)
            res = -res;
        return res;
    }
    
    static public void main (String[] argv){
    	int dividend = 9;
    	int divisor = 4;
    	System.out.print(new DivideTwoIntegers().divide(dividend, divisor));
    }
}
