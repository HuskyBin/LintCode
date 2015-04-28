/*
Easy Two Strings Are Anagrams Show result 

38% Accepted
Write a method anagram(s,t) to decide if two strings are anagrams or not.

Example
Given s="abcd", t="dcab", return true.

Challenge
O(n) time, O(1) extra space
*/
public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            }
            else {
                charMap.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (!charMap.containsKey(c) || charMap.get(c) == 0) {
                return false;
            }
            charMap.put(c, charMap.get(c) - 1);
        }
        return true;
    }
};
