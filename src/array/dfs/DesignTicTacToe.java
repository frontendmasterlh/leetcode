package array.dfs;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

 You may assume the following rules:

 A move is guaranteed to be valid and is placed on an empty block.
 Once a winning condition is reached, no more moves is allowed.
 A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 */
public class DesignTicTacToe {
    int n;
    int[] rows;
    int[] cols;
    int dia;
    int antiDia;
    int winner;

    public DesignTicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        dia = 0;
        antiDia = 0;
        winner = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player == 1) {
            rows[row]++;
            cols[col]++;
            if (row + col == n - 1) {
                dia++;
            }
            if (row == col) {
                antiDia++;
            }
        } else if (player == 2) {
            rows[row]--;
            cols[col]--;
            if (row + col == n - 1) {
                dia--;
            }
            if (row == col) {
                antiDia--;
            }
        }

        if (rows[row] == n || cols[col] == n || dia == n || antiDia == n) {
            winner = 1;
        }
        if (rows[row] == -n || cols[col] == -n || dia == -n || antiDia == -n) {
            winner = 2;
        }
        return winner;
    }
}
