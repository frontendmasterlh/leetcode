package leetcode_M;

//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i=0; i< m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j]=='0'){
                    dp[i][j] = 0;
                }
                else if (j > 0){
                    dp[i][j] = dp[i][j-1] +1;
                }else 
                    dp[i][j] = 1;
            }
        }
        int max=0, cur = 0;
        for (int i=0; i< m; i++) {
            for (int j=0; j< n; j++){
                int k = i;
                int min = dp[i][j];
                while (k>=0 && dp[k][j]!=0) {
                    min = Math.min(min, dp[k][j]);
                    cur = min * (i-k+1);
                    max = Math.max(max, cur);
                    k--;
                }
            }
        }
        return max;
    }
	
	static public void main (String argv[]){
		char[][] matrix = {{'0','1'},{'1','1'}};
		System.out.println(new MaximalRectangle ().maximalRectangle(matrix));
	}
}
