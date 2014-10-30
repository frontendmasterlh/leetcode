package leetcode_S;

public class SudokuSolver {
	private boolean isValid (char[][] board, int a, int b) {
        int i = 0, j= 0;
        for (i = 0; i< 9; i++) {
            if (i!=a && board[i][b]==board[a][b])
                return false;
        }
        for (j=0; j<9; j++){
            if (j!=b && board[a][j]==board[a][b])
                return false;
        }
        int x = a / 3 * 3;
        int y = b / 3 * 3;
        for (i=0; i<3; i++){
            for (j = 0; j<3; j++){
                if ((i+x!=a && j+y!= b) && board[a][b]==board[i+x][j+y])
                    return false;
            }
        }
        return true;
    }
    
    private boolean helpsolver (char[][] board){
       for (int i=0; i< 9; i++){
            for (int j = 0; j< 9; j++){
                if (board[i][j]=='.'){
                    for (int k = 1; k<=9; k++){//typical dfs.
                        board[i][j] = (char)(k+'0') ;//Casting!!!
                        if (isValid(board, i, j) && helpsolver(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;//We've tried all 9 numbers and failed. So return false.
                }
            }
        } 
        return true;
    }
    
    public void solveSudoku(char[][] board) {
        helpsolver (board);
    }
    
    static public void main (String[] argv){
    	;
    }
}
