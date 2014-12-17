/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null || word2 == null) {
            return 0;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int min = Integer.MAX_VALUE;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    min = Math.min(dp[i - 1][j - 1], min);
                }
                else {
                    min = Math.min(dp[i - 1][j - 1] + 1, min);
                }
                min = Math.min(dp[i - 1][j] + 1, min);
                min = Math.min(dp[i][j - 1] + 1, min);
                dp[i][j] = min;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
