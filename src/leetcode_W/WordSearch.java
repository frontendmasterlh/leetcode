package leetcode_W;

public class WordSearch {
	private boolean search (char[][] board, int i, int j, String word, boolean[][] visited) {
        if (word.length() <= 0)
            return true;
        
        int[][] direction = {{1,0},{-1,0},{0,1},{0, -1}};
        
        for (int k = 0; k < direction.length; k++){
            int ii = i + direction[k][0];
            int jj = j + direction[k][1];
            if (ii>=0 && ii< board.length && jj >= 0 && jj < board[i].length && board[ii][jj] == word.charAt(0) && visited[ii][jj]==false){
                visited[ii][jj] = true;
                if (word.length()==1 || search(board, ii, jj, word.substring(1), visited))
                    return true;
                visited[ii][jj] = false;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        if (word==null || word.length()==0)
            return true;
        if (board==null || board.length==0 || board[0].length==0)
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];// Record whether it has been visited or not.
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if (word.length()==1 || search(board, i, j, word.substring(1),visited))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    static public void main (String[] argv) {
    	;
    }
}
