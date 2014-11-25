/*
Given two strings, find the longest common substring.

Return the length of it.

Note
The characters in substring should occur continiously in original string. This is different with subsequnce.


*/
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int result = 0;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = 0;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
