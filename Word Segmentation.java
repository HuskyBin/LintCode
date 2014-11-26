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



// Careful about the MaxLength improvement

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
        if (s.length() == 0) {
            return true;
        }
        int maxLength = getMaxLength(dict);
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            for (int j = i - 1;(i - j) <= maxLength && j >= 0; j--) {
                if (dp[j] == true && dict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
    
    private int getMaxLength(Set<String> dict) {
        int max = 0;
        for (String word : dict) {
            max = Math.max(max, word.length());
        }
        return max;
    }
}
