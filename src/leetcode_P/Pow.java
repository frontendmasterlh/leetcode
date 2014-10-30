package leetcode_P;

public class Pow {
    public double pow(double x, int n) {
        if (n==0)
            return 1.0;
        if (n>0){
            double half = pow(x, n>>1);
            if (n%2==0){
                return half * half;
            }else
                return half * half * x;
        }else {
            double half = pow(x, (-n)>>1);
            if (n%2==0){
                return 1 /(half * half);
            }else
                return 1 / (half * half * x);
        }
    }
    
    static public void main (String[] argv){
    	System.out.println(new Pow().pow(2, 10));
    }
}
