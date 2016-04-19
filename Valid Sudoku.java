/*
Determine whether a Sudoku is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character ..

Have you met this question in a real interview? Yes
 Notice

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

Clarification
What is Sudoku?

http://sudoku.com.au/TheRules.aspx
https://zh.wikipedia.org/wiki/%E6%95%B8%E7%8D%A8
https://en.wikipedia.org/wiki/Sudoku
http://baike.baidu.com/subview/961/10842669.htm
Example
The following partially filed sudoku is valid.

Valid Sudoku
*/
class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return true;
        }
        int[] rows = new int[board.length];
        int[] columns = new int[board[0].length];
        
        int[][] matrix = new int[board.length / 3][board[0].length / 3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curInt = board[i][j] - '0';
                if ((rows[i] & ( 1 << curInt)) != 0) {
                    return false;
                }
                else {
                    rows[i] |= 1 << curInt;
                }
                if ((columns[j] & (1 << curInt)) != 0) {
                    return false;
                }
                else {
                    columns[j] |= 1 << curInt;
                }
                int matrixRow = i / 3;
                int matrixColumn = j / 3;
                if ((matrix[matrixRow][matrixColumn] & (1 << curInt)) != 0) {
                    return false;
                }
                else {
                    matrix[matrixRow][matrixColumn] |= 1 << curInt;
                }
            }
        }
        return true;
    }
};
