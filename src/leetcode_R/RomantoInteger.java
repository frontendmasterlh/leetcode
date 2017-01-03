package leetcode_R;

public class RomantoInteger {
	private int tran (char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    
    public int romanToInt(String s) {
        int res=0;
        for (int i=0; i<s.length(); i++) {
            if (i>0 && tran(s.charAt(i)) > tran(s.charAt(i-1))){
                res += tran(s.charAt(i)) - 2 * tran(s.charAt(i-1));
            }else {
                res +=tran(s.charAt(i));
            }
        }
        return res;
    }
    
    static public void main (String[] argv){
    	String s = "DCXIV";
    	System.out.println(new RomantoInteger().romanToInt(s));
    }
}
