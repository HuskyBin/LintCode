/*
Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

Example
For A = "ABCD", B = "ABC", return true.

For A = "ABCD" B = "AABC", return false.
*/
public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() < B.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        int count = B.length();
        for (int i = 0; i < B.length(); i++) {
            char curChar = B.charAt(i);
            if (!map.containsKey(curChar)) {
                map.put(curChar, 1);
            }
            else {
                map.put(curChar, map.get(curChar) + 1);
            }
        }
        for (int i = 0; i < A.length(); i++) {
            char curChar = A.charAt(i);
            if (map.containsKey(curChar)) {
                int curInt = map.get(curChar);
                if (curInt != 0) {
                    map.put(curChar, curInt - 1);
                    count--;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }
}
