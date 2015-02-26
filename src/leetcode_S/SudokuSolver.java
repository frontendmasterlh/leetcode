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
    
    private boolean[][] row;
    private boolean[][] col;
    private boolean[][] blo;
    
    public void solveSudoku2(char[][] board) {
        int n = board.length;
        row = new boolean[n][n];
        col = new boolean[n][n];
        blo = new boolean[n][n];
        init(board);
        backtrack(board);
        
        print(board);
    }
    
    private void print(char[][] board) {
        for (int i =0; i< 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		System.out.print(board[i][j] + "  ");
        	}
        	System.out.println();
        }    	
    }
    
    private void init (char[][] board) {
        for (int i =0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int k = i /3 *3 + j/3;
                    int num = board[i][j] - '0' - 1;
                    row[i][num] = col[j][num] = blo[k][num] = true;
                }
            }
        }
    }
    
    private boolean isValid (int i, int j, int k, int num) {
        if (row[i][num] || col[j][num] || blo[k][num]) {
            return false;
        }else 
            return true;
    }
    
    private boolean backtrack(char[][] board) {
        for (int i = 0; i<  board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (int num = 0; num < 9; num++) { // num is from 1 to 9.
                        board[i][j] = (char)(num + '0' + 1) ;
                        int k = i /3 *3 + j/3;
                        if (isValid(i, j, k, num)) {
                            row[i][num] = col[j][num] = blo[k][num] = true;
                            if (backtrack(board)){
                                return true;
                            }
                            row[i][num] = col[j][num] = blo[k][num] = false;
                        }
                        board[i][j] = '.';
                    }
                    return false;    //We've tried all 9 possible answers.
                }
            }
        }
        return true;
    }
    
    static public void main (String[] argv){
    	String[] s = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
    	char[][] board = new char[9][9];
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			board[i][j] = s[i].charAt(j);
    		}
    	}
    	
    	SudokuSolver ss = new SudokuSolver();
    	ss.solveSudoku(board);
    	ss.solveSudoku2(board);//Using 2 - d array to mark the position
    }
}
