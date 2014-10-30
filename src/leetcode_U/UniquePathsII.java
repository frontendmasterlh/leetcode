package leetcode_U;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid== null || obstacleGrid.length==0 || obstacleGrid[0].length==0)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        for (int i=0; i< m; i++) {
            if (obstacleGrid[i][0]==1)
                break;
            else
                path[i][0] = 1;
        }
        for (int i = 0; i< n; i++){
            if (obstacleGrid[0][i]==1)
                break;
            else
                path[0][i] = 1;
        }
        
        for (int i = 1; i< m; i++) {
            for (int j = 1; j <n; j++) {
                if (obstacleGrid[i][j] == 0)
                    path[i][j] = path[i-1][j] + path[i][j-1];
                else //If the value is 1, that mean it's a obstacle.
                    path[i][j] = 0;
            }
        }
        return path[m-1][n-1];
    }
	
	static public void main (String[] argv) {
		;
	}
}
