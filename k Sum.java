/*
Easy k Sum Show Result My Submissions

10% Accepted
Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Example
Given [1,2,3,4], k=2, target=5. There are 2 solutions:

[1,4] and [2,3], return 2.


*/
// 滚动数组
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int result = 0;
    public int kSum(int[] A,int k,int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        /*int[][][] dp = new int[A.length + 1][k + 1][target + 1];
        for (int i = 1; i <= A.length; i++) {
            if (A[i - 1] <= target) {
                for (int j = i; j <= A.length; j++) {
                    dp[j][1][A[i - 1]] = 1;
                }
            }
        }*/
        int[][] dp = new int[k + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = Math.min(i, k); j >= 1; j--) {
                for (int m = target; m >= A[i - 1]; m--) {
                    dp[j][m] += dp[j - 1][m - A[i - 1]];
                }
            }
        }
        return dp[k][target];
    }
   
}
