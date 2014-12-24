/*
Easy Number Triangle Show Result My Submissions

34% Accepted
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Note
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Example
For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        int column = triangle.get(row - 1).size();
        int[][] dp = new int[row][column];
        for (int i = 0; i < column; i++) {
            ArrayList<Integer> lastRow = triangle.get(row - 1);
            dp[row - 1][i] = lastRow.get(i);
        }
        for (int i = row - 2; i >= 0; i--) {
            int number = triangle.get(i).size();
            for (int j = 0; j < number; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
