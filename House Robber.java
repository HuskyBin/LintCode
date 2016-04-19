/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Have you met this question in a real interview? Yes
Example
Given [3, 8, 4], return 8.


*/
public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        long[] dp = new long[A.length];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            dp[i] = Math.max(A[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[A.length - 1];
    }
}
