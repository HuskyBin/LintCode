/*
Fair Interleaving String Show Result My Submissions

24% Accepted
Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Example
For s1 = "aabcc" s2 = "dbbca"

    - When s3 = "aadbbcbcac", return true.

    - When s3 = "aadbbbaccc", return false.

Challenge Expand 
*/
public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null || s3 == null || 
            s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1][0] = true;
            }
            else {
                break;
            }
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s3.charAt(i)) {
                dp[0][i + 1] = true;
            }
            else {
                break;
            }
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int n = 1; n <= s2.length(); n++) {
                if (s2.charAt(n - 1) == s3.charAt(i + n - 1) && dp[i][n - 1]) {
                    dp[i][n] = true;
                }
                else if (s1.charAt(i - 1) == s3.charAt(i + n - 1) && dp[i - 1][n]) {
                    dp[i][n] = true;
                }
                else {
                    dp[i][n] = false;
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
        
    }
    
    
}

               
               
