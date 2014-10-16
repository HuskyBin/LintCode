/*
Follow up for N-Queens problem. Now, instead outputting board configurations, return the total number of distinct solutions.
Example
For n=4, there are 2 distinct solutions.
*/
class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    private int count = 0;
    public int totalNQueens(int n) {
        //write your code here
        if (n <= 0) {
            return 0;
        }
        int[] row = new int[n];
        totalNQueensCore(n, row, 0);
        return count;
    }
    
    private void totalNQueensCore(int n, int[] row, int index) {
        if (index == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, index, i)) {
                row[index] = i;
                totalNQueensCore(n, row, index + 1);
                row[index] = 0;
            }            
        }
    }
    
    private boolean isValid(int[] row, int rowNum, int column) {
        for (int i = 0; i < rowNum; i++) {
            if (row[i] == column) {
                return false;
            }
            if (Math.abs(row[i] - column) == Math.abs(i - rowNum)) {
                return false;
            }
        }
        return true;
    }
};


