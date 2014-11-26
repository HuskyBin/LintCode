/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Example
Given

s = "lintcode",

dict = ["lint", "code"].

Return true because "lintcode" can be segmented as "lint code".


*/
// Recursion (will be stack over flow)
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordSegmentation(String s, Set<String> dict) {
        // write your code here   
        if (s == null || dict == null || dict.size() == 0) {
            return false;
        }
        int[] dp = new int[s.length()];
        return wordSegmentationHelper(s, dict, 0, dp);
    }
    
    private boolean wordSegmentationHelper(String s, Set<String> dict, int index, int[] dp) {
        if (index == s.length()) {
            return true;
        }
        if (dp[index] != 0) {
            return dp[index] == -1 ? false : true;
        }
        for (int i = index; i < s.length(); i++) {
            String substr = s.substring(index, i + 1);
            if (dict.contains(substr)) {
                boolean subResult = wordSegmentationHelper(s, dict, i + 1, dp);
                if (subResult == true) {
                    return true;
                }
            }
        }
        dp[index] = -1;
        return false;
    }
}
