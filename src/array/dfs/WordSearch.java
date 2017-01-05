package array.dfs;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class WordSearch {
    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        // The 1st method: with a visited array
        // boolean[][] visited = new boolean[board.length][board[0].length];
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[i].length; j++) {
        //         if (board[i][j] == word.charAt(0)) {
        //             visited[i][j] = true;
        //             if (backTrack(board, word, visited, 1, i, j)) {
        //                 return true;
        //             }
        //             visited[i][j] = false;
        //         }
        //     }
        // }
        // return false;

        // The 2nd method: without a visited array
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backTrack2(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, String word, boolean[][] visited, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length &&
                    !visited[x][y] && word.charAt(index) == board[x][y]) {
                if (backTrack(board, word, visited, index + 1, x, y)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    private boolean backTrack2(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j]) {
            return false;
        }

        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if (backTrack2(board, word, x, y, index + 1)) {
                return true;
            }
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}
