package leetcode_W;

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int backtracks = -1;
        int backtrackp = -1;
        while (i < s.length()){
            if (j < p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                i++;
                j++;
            }else {
                if (j < p.length() && p.charAt(j)=='*') {
                    while (j < p.length() && p.charAt(j)=='*')
                        j++;
                    if (j == p.length())
                        return true;
                    else {
                        backtracks = i;
                        backtrackp = j;
                    }
                }else {
                    if (backtrackp != -1){
                        i = ++backtracks;
                        j = backtrackp;
                    }else
                        return false;
                }
            }
        }
        while (j < p.length() &&  p.charAt(j)=='*')
            j++;
        return i==s.length() && j==p.length();
    }
	
	static public void main (String[] argv) {
		String s = "b";
		String p = "*?*?";
		System.out.println(new WildcardMatching().isMatch(s, p));
	}
}
