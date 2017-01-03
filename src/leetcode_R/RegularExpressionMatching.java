package leetcode_R;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        if (p.length()==0)
            return s.length()==0;
        if (p.length()==1){
            return s.length()==1 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        }
        if (p.charAt(1)!='*'){
            if (s.length()> 0 && (s.charAt(0)==p.charAt(0)|| p.charAt(0)=='.')){
                return isMatch (s.substring(1), p.substring(1));
            }else
                return false;
        }else {
            while (s.length() >0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')){
                if (isMatch(s, p.substring(2))){
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
	}
	
	static public void main (String[] argv){
		String s = "aab";
		String p = "c*a*b";
		System.out.println(new RegularExpressionMatching().isMatch(s, p));
	}
}
