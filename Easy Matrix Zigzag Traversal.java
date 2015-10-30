/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.

Have you met this question in a real interview? Yes
Example
Given a matrix:

[
  [1, 2,  3,  4],
  [5, 6,  7,  8],
  [9,10, 11, 12]
]
return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
*/
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix == null) {
            return null;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int count = row * column;
        int[] result = new int[count];
        int i = 1;
        int r = 0;
        int c = 0;
        result[0] = matrix[r][c]; 
        while (i < count) {
            if (i < count && c < column - 1) {
                result[i++] = matrix[r][++c];
            }
            else if (i < count && r < row - 1) {
                result[i++] = matrix[++r][c];
            }

            while (i < count && r < row - 1 && c > 0) {
                result[i++] = matrix[++r][--c];
            }

            if (i < count && r < row - 1) {
                result[i++] = matrix[++r][c];
            }
            else if (i < count && c < column - 1) {
                result[i++] = matrix[r][++c];
            }

            while (i < count && r > 0 && c < column - 1) {
                result[i++] = matrix[--r][++c];
            }
        }
        return result;
    }
}
