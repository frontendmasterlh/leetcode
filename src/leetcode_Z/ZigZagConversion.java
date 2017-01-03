package leetcode_Z;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
        if (s==null || s.length()==0 || nRows <= 1)
            return s;
        StringBuffer res = new StringBuffer ();
        int len = s.length();
        for (int i=0; i<nRows && i<len; i++) {
            int idx = i;
            res.append(s.charAt(idx));  //the elem in first col
            
            for (int k = 1; idx < len; k++) {
                if (i==0 || i == nRows -1){
                    idx += 2 * nRows - 2;
                }else {
                    if (k % 2 ==1){         //odd row
                        idx += 2 * (nRows - 1 - i); 
                    }else
                        idx += 2 * i;       //even row
                }
                if (idx < len)
                    res.append(s.charAt(idx));
            }
        }
        return res.toString();
    }
	
	static public void main (String[] argv) {
		String s = "PAYPALISHIRING";
		int nRows = 3;
		String res = new ZigZagConversion().convert(s, nRows);
		System.out.println(res);
	}
}
