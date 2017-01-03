package leetcode_D;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] f = new int[m+1][n+1];
        f[0][0] = 1;
        for (int i =1; i< m; i++){
            f[i][0] = 1;
        }
        for (int i=1; i < n; i++){
            f[0][i] = 0;
        }
        
        for (int i=1; i <=m; i++) {
            for (int j =1; j <= n; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)){
                    f[i][j] = f[i-1][j-1] + f[i-1][j];
                }else {
                    f[i][j] = f[i-1][j];
                }
            }
        }
        return f[m][n];
    }
	
	static public void main (String[] argv) {
		String S = "habbbit";
		String T = "habbit";
		System.out.println(new DistinctSubsequences().numDistinct(S, T));
	}
}
