package array.maths;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    // Time: O(n^2) Space: O(n^2)
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[k][num]) {
                        return false;
                    } else {
                        row[i][num] = col[j][num] = block[k][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
