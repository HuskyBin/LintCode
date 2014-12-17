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


// DP  
/*
此题需要使用大数运算。使用一点 DP 即可。关键是如何得到递推关系，可以这样想，设母串的长度为 j，  
子串的长度为 i，我们要求的就是长度为 i 的字串在长度为 j 的母串中出现的次数，设为 t[i][j]，若母串的最后一个字符与子串的最后一个字符不同，则长度为 i 的子串在长度为 j 的母串中出现的次数就是母串的前 j - 1 个字符中子串出现的次数，即 t[i][j] = t[i][j - 1]，若母串的最后一个字符与子串的最后一个字符相同，那么除了前 j - 1 个字符出现字串的次数外，还要加上子串的前 i - 1 个字符在母串的前 j - 1 个字符中出现的次数，即 t[i][j] = t[i][j - 1] + t[i - 1][j - 1]。  
*/

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
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); i++) {
        	dp[i][0] = 1;
        }
        
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
    
    
}
