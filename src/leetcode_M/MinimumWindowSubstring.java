package leetcode_M;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
        if (T==null || S==null || T.length()==0 || S.length() < T.length())
            return "";
        int m = S.length();
        int n = T.length();
        int[] needfind = new int[256];//ASCII code number.
        int[] hasfind  = new int[256];
        int minbegin = 0, minend = 0, minwindow = m+1;//Make length longer than m¡£
        int begin = 0, end = 0;
        int count = 0;
        for (int i=0; i<n; i++) {//Mark all the characters and their numbers.
            needfind[T.charAt(i)]++;
        }
        
        for (; end < m; end++){
            if (needfind[S.charAt(end)]==0)//We don't need this character.
                continue;
            hasfind[S.charAt(end)]++;
            if (hasfind[S.charAt(end)] <= needfind[S.charAt(end)])
                count++;
            if (count==n) {
                while (needfind[S.charAt(begin)]==0 || hasfind[S.charAt(begin)] > needfind[S.charAt(begin)]){
                    if (hasfind[S.charAt(begin)] > needfind[S.charAt(begin)])
                        hasfind[S.charAt(begin)]--;
                    begin++;
                }
                int len = end - begin +1;//The length of the window.
                if (len < minwindow){
                    minbegin = begin;
                    minend = end;
                    minwindow = len;
                }
            }
        }
        if (minwindow > m)// We couldn't find it.
            return "";
        else
            return S.substring (minbegin, minend+1);//minbegin + minwindow
    }
	
	static public void main (String argv[]){
		System.out.println(new MinimumWindowSubstring ().minWindow("ADOBECODEBANC", "ABC"));
	}
}
