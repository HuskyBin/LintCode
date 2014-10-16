/*
Fair Minimum Window Substring Show Result My Submissions

13% Accepted
Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

Note
If there is no such window in source that covers all characters in target, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

Example
source = "ADOBECODEBANC" target = "ABC" Minimum window is "BANC".


*/
public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if (source == null || target == null || target.length() > source.length()) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int minStart = 0;
        int appeared = 0;
        char[] expected = new char[128];
        char[] showed = new char[128];
        for (char c : target.toCharArray()) {
            //int cIndex = (int)c;
            expected[c]++;
        }
        for (end = 0; end < source.length(); end++) {
            char curChar = source.charAt(end);
            if (expected[curChar] > 0) {
                showed[curChar]++;
                if (showed[curChar] <= expected[curChar]) {
                    appeared++;
                }
            }
            if (appeared == target.length()) {
                char startChar = source.charAt(start);
                while (expected[startChar] == 0 || (showed[startChar] > expected[startChar])) {
                    if (showed[startChar] > 0) {
                        showed[startChar]--;
                    }
                    start++;
                    startChar = source.charAt(start);
                }
                if (min > (end - start + 1)) {
                    min = end - start + 1;
                    minStart = start;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        return source.substring(minStart, minStart + min);
        
    }
}
