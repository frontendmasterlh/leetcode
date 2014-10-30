package leetcode_S;

public class SqrtX {
	public int sqrt(int x) {
        double e = 0.0001;
        double res  = x;
        while (Math.abs(res * res - (double)x) > e){
            res = (res + x/ res) /2;
        }
        return (int)res;
    }
	
	static public void main (String[] argv){
		int x = 8;
		System.out.println(new SqrtX().sqrt(x));
	}
}
