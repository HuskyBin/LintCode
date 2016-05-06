/*
Given a string, find the length of the longest substring without repeating characters.

Have you met this question in a real interview? Yes
Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
*/
public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int result = 0;
        while (end < s.length()) {
            char curChar = s.charAt(end);
            if (!set.contains(curChar)) {
                set.add(curChar);
                end++;
                result = Math.max(result, end - start);
            }
            else {
                while (s.charAt(start) != curChar) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.remove(curChar);
                start++;
            }
        }
        return result;
    }
}
