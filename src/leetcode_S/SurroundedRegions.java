package leetcode_S;

import java.util.*;

public class SurroundedRegions {
	Queue<Integer> q;
    int m,n;
    
    private void add(char[][] board, int x, int y) {
        if (x>=0 && x < board.length && y>=0 && y< board[0].length && board[x][y]=='O') {
            board[x][y] = 'C';
            q.offer(x * n + y);
        }
    }
    
    private void traverse (char[][] board, int x, int y){
        add(board, x, y);
        while (!q.isEmpty()){
            int temp = q.poll();
            int tempx = temp / n, tempy = temp % n;
            add(board, tempx+1, tempy);
            add(board, tempx-1, tempy);
            add(board, tempx, tempy+1);
            add(board, tempx, tempy-1);
        }
    }
    
    public void solve(char[][] board) {
        if (board==null || board.length==0 || board[0].length== 0)
            return ;
        q = new LinkedList<Integer> ();
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            traverse (board, i, 0);
            traverse (board, i, n-1);
        }
        
        for (int i=0; i < n; i++){
            traverse (board, 0, i);
            traverse (board, m-1, i);
        }
        
        for (int i=0; i< m; i++) {
            for (int j=0; j< n; j++) {
                if (board[i][j]=='C'){
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
    
    static public void main (String[] argv) {
    	;
    }
}
