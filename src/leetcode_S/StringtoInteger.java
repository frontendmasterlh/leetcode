package leetcode_S;

public class StringtoInteger {
	public int atoi(String str) {
        str = str.trim();
        long res = 0;
        if (str.equals(""))
            return 0;
        int flag = 1;
        for (int i=0; i< str.length(); i++){
            if (i==0 && (str.charAt(i)=='+' || str.charAt(i)=='-')){
                if (str.charAt(i)=='-')
                    flag = -1;
                continue;
            }
            if (str.charAt(i)<'0' || str.charAt(i)>'9')
                break;
            res = res * 10 + str.charAt(i) - '0';
        }
        res = res * flag;
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)res;
    }
	
	static public void main (String[] argv) {
		String str = "   -125146.23  ";
		System.out.println(new StringtoInteger().atoi(str));
	}
}
