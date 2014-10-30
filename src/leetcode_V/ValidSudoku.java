package leetcode_V;

public class ValidSudoku {
	private boolean isValid(char[][] board, int a, int b){
        for (int i = 0; i < 9; i++) {
            if (i!=a && board[a][b] == board[i][b])
                return false;
            if (i!=b && board[a][b] == board[a][i])
                return false;
        }
        int x = a /3 *3;
        int y = b /3 *3;
        for (int i = 0; i<3 ; i++) {
            for (int j=0; j <3; j++) {
                if ((i+x != a && j+y !=b) && board[a][b]==board[i+x][j+y])
                    return false;
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            for (int j = 0; j<9; j++){
                if (board[i][j]!='.'){
                    if (!isValid(board, i, j))
                        return false;
                }
            }
        }
        return true;
    }
    
    static public void main (String[] argv) {
    	;
    }
}
