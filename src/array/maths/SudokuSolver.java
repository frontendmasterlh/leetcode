package array.maths;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
    private boolean[][] row;
    private boolean[][] col;
    private boolean[][] blo;

    public void solveSudoku(char[][] board) {
        int n = board.length;
        row = new boolean[n][n];
        col = new boolean[n][n];
        blo = new boolean[n][n];
        init(board);
        backtrack(board);
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
                    for (int num = 0; num < 9; num++) {
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
}
