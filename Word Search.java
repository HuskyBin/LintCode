/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                boolean result = existHelper(board, word, i, j, 0, visited);
                if (result == true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean existHelper(char[][] board, String word, int row, int column, int index, boolean[][] visited){
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return false;
        }
        if (visited[row][column] == true) {
            return false;
        }
        boolean result = false;
        if (word.charAt(index) != board[row][column]) {
            return false;
        }
        visited[row][column] = true;
        result = existHelper(board, word, row - 1, column, index + 1, visited);
        if (result == true) {
            return result;
        }
        result = existHelper(board, word, row + 1, column, index + 1, visited);
        if (result == true) {
            return result;
        }
        result = existHelper(board, word, row, column - 1, index + 1, visited);
        if (result == true) {
            return result;
        }
        result = existHelper(board, word, row, column + 1, index + 1, visited);
        if (result == true) {
            return result;
        }
        visited[row][column] = false;
        return false;
    }
}
