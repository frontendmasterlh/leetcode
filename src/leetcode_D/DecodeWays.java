package leetcode_D;

public class DecodeWays {
	public int numDecodings(String s) {
        if (s== null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] f = new int[n];
        
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return 0;
            if (s.charAt(i) == '0'){
                if (i==0 || s.charAt(i-1)=='0' || s.charAt(i-1) > '2')
                    return 0;
                else
                    f[i] = i>1 ? f[i-2] : 1;
            }else if ( i>0 && ( (s.charAt(i-1)== '1') || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'))){
                f[i] = (i> 1 ? f[i-2] : 1) + (i >0 ? f[i-1] : 1);
            }else
                f[i] = i >0 ?f[i-1] : 1;
        }
        return f[n-1];
    }
	
	static public void main (String[] argv) {
		DecodeWays dw = new DecodeWays();
		String s = "110";//"116";
		System.out.println(dw.numDecodings(s));
	}
}
