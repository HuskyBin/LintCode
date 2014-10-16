/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example
There exist two distinct solutions to the 4-queens puzzle:

[

    [".Q..", // Solution 1

     "...Q",

     "Q...",

     "..Q."],

    ["..Q.", // Solution 2

     "Q...",

     "...Q",

     ".Q.."]

]
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        if (n <= 0) {
            return resultList;
        }
        int[] row = new int[n];
        solveNQueensCore(resultList, row, n, 0);
        return resultList;
    }
    
    private void solveNQueensCore(ArrayList<ArrayList<String>> resultList,
                              int[] row,
                              int n,
                              int index) {
        if (index == n) {
            ArrayList<String> singleResult = translateString(row);
            resultList.add(singleResult);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(row, index, i)) {
                row[index] = i;
                solveNQueensCore(resultList, row, n, index + 1);
                row[index] = 0;
            }
        }
    }
    
    private ArrayList<String> translateString(int[] row) {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                if (j == row[i]) {
                    sb.append('Q');
                }
                else {
                    sb.append('.');
                }
            }
            resultList.add(sb.toString());
        }
        return resultList;
    }
    
    private boolean isValid(int[] row, int rowNum, int columnNum) {
        for (int i = 0; i < rowNum; i++) {
            if (row[i] == columnNum) {
                return false;
            }
            if (Math.abs(row[i] - columnNum) == Math.abs(i - rowNum)) {
                return false;
            }
        }
        return true;
    }
    
};
