/*
Fair Distinct Subsequences Show Result My Submissions

30% Accepted
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).



Example
S = "rabbbit", T = "rabbit"

Return 3.
*/

// recursion
public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null || S.length() == 0 || T.length() == 0 || S.length() < T.length()) {
            return 0;
        }
        int[][] dp = new int[S.length()][T.length()];
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < T.length(); j++) {
                dp[i][j] = -1;
            }
        }
        
        int result = numDistinctHelper(S, T, 0, 0, dp);
        return result;
    }
    
    private int numDistinctHelper(String S, String T, int sIndex, int tIndex, int[][] dp) {
        if (sIndex == S.length() && tIndex < T.length()) {
            return 0;
        }
        if (tIndex == T.length()) {
            return 1;
        }
        if (dp[sIndex][tIndex] != -1) {
            return dp[sIndex][tIndex];
        }
        int result = 0;
        for (int i = sIndex; i < S.length(); i++) {
            if (T.charAt(tIndex) == S.charAt(i)) {
                result += numDistinctHelper(S, T, i + 1, tIndex + 1, dp);
            }
        }
        dp[sIndex][tIndex] = result;
        return result;
    }
}
