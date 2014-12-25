/*
Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example
For example, given s = "aab",

Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

Tags Expand 
*/
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < isPalindrome.length; i++) {
            isPalindrome[i][i] = true;
        }
        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0; start + len - 1 < s.length(); start++) {
                int end = start + len - 1;
                if (len == 2) {
                    if (s.charAt(start) == s.charAt(end)) {
                        isPalindrome[start][end] = true;
                    }
                }
                else {
                    if (s.charAt(start) == s.charAt(end) && isPalindrome[start + 1][end - 1] == true) {
                        isPalindrome[start][end] = true;
                    }
                }
            }
        }
        
        int[] minCut = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (j == 0 && isPalindrome[j][i] == true) {
                    min = 0;
                    break;
                }
                if (isPalindrome[j][i] == true) {
                    min = Math.min(min, minCut[j - 1] + 1);
                }
            }
            minCut[i] = min;
        }
        return minCut[s.length() - 1];
    }
    
};
