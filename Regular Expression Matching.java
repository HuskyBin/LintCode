/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)
Example
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }
        return isMatchHelper(s, p, 0, 0);
    }
    
    private boolean isMatchHelper(String s, String p, int sIndex, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (pIndex == p.length() && sIndex < s.length()) {
            return false;
        }
        if (sIndex == s.length() && pIndex < p.length()) {
            if (p.charAt(pIndex) == '*') {
                pIndex++;
            }
            while (pIndex < p.length()) {
                if (p.charAt(pIndex) == '*') {
                    pIndex++;
                }
                else {
                    if ((pIndex < p.length() - 1) && p.charAt(pIndex + 1) == '*') {
                        pIndex += 2;
                    }
                    else {
                        break;
                    }
                }
            }
            if (pIndex >= p.length()) {
                return true;
            }
            return false;
        }
        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            boolean subResult = isMatchHelper(s, p, sIndex, pIndex + 2);
            if (subResult == true) {
                return true;
            }
            if (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.') {
                subResult = isMatchHelper(s, p, sIndex + 1, pIndex);
                if (subResult == true) {
                    return true;
                }
            }
        }
        else {
            if (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.') {
                boolean subResult = isMatchHelper(s, p, sIndex + 1, pIndex + 1);
                if (subResult == true) {
                    return true;
                }
            }
        }
        return false;
        
    }
}
