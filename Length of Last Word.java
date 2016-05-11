/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

 Notice

A word is defined as a character sequence consists of non-space characters only.

Have you met this question in a real interview? Yes
Example
Given s = "Hello World", return 5.
*/
public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (end >= 0 && s.charAt(end) != ' ') {
            end--;
        }
        return start - end;
    }
}
