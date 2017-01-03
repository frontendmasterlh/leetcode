package leetcode_S;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {//In this problem, it needs to improve the space usability.
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return ;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = 0;
        for (int i=0; i< m; i++){
            if (matrix[i][0]==0){
                row = 1;
                break;
            }
        }
        for (int i=0; i< n; i++){
            if (matrix[0][i]==0){
                col = 1;
                break;
            }
        }
        
        for (int i=1; i< m; i++) {
            for (int j =1; j < n; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=1; i< m; i++) {
            for (int j=1; j < n; j++) {
                if (matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
        }
        if (row==1){
            for (int i= 0; i< m; i++){
                matrix[i][0] = 0;
            }            
        }
        if (col==1){
            for (int j=0; j< n; j++) {
                matrix[0][j] = 0;
            }
        }

    }
	
	public static void main(String[] args) {
		// int[][] b = new int[4][5];
		int[][] b = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
				{ 1, 2, 1, 3 }, { 0, 0, 1, 1 } };

		// for (int i = 0; i < 5; i++) {
		// for (int j = 0; j < 4; j++) {
		// b[i][j] = 2;
		//
		// }
		// }
		// b[2][3] = 0;
		// b[1][1] = 0;

		for (int s = 0; s < 5; s++) {
			System.out.println("");
			for (int j = 0; j < 4; j++) {
				System.out.print(b[s][j] + " ");
			}
		}
		System.out.println("");
		(new SetMatrixZeroes()).setZeroes(b);
		System.out.println("");

		for (int s = 0; s < 5; s++) {
			System.out.println("");
			for (int j = 0; j < 4; j++) {
				System.out.print(b[s][j] + " ");
			}
		}

	}
}
