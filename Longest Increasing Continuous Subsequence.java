/*
Give an integer array，find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.
 Notice

O(n) time and O(1) extra space.

Have you met this question in a real interview? Yes
Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
*/
public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int leftToRightMax = 1;
        int rightToLeftMax = 1;
        int curLeftToRight = 1;
        int curRightToLeft = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                curRightToLeft++;
                rightToLeftMax = Math.max(rightToLeftMax, curRightToLeft);
                curLeftToRight = 1;
            }
            else if (A[i] > A[i - 1]) {
                curRightToLeft = 1;
                curLeftToRight++;
                leftToRightMax = Math.max(leftToRightMax, curLeftToRight);
            }
            else {
                curRightToLeft++;
                rightToLeftMax = Math.max(rightToLeftMax, curRightToLeft);
                curLeftToRight++;
                leftToRightMax = Math.max(leftToRightMax, curLeftToRight);
            }
        }
        return Math.max(leftToRightMax, rightToLeftMax);
    }
}
