package leetcode_R;

public class ReverseInteger {
	public int reverse(int x) {
        int flag = 1;
        if (x < 0){
            flag = -1;
            x = -x; 
        }
        int temp = 0;
        while (x>0) {
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        return temp*flag;
    }
	
	static public void main (String[] argv) {
		System.out.println(new ReverseInteger().reverse(1232456));
	}
}
