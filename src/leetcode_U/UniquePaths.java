package leetcode_U;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        if (m <=0 || n <= 0)
            return 0;
        int[][] path = new int[m][n];
        
        for (int i=0; i < m; i++) {//For path[i][0], it has only one path.
            path[i][0] = 1;
        }
        for (int i=1; i < n; i++) {//For path[0][i], it has only one path.
            path[0][i] = 1;
        }
        for (int i=1; i< m; i++) {
            for (int j=1; j < n; j++){
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }
	
	static public void main (String[] argv){
		int m = 4;
		int n= 5;
		System.out.println(new UniquePaths().uniquePaths(m, n));
	}
}
