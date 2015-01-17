/*
Given string A representative a positive integer which has N digits, remove any k digits of the number, the remaining digits are arranged according to the original order to become a new minimal positive integer. 
N <= 240 and k <=N, 
Example
Given an integer A = 178542, k = 4

return a string "12"


*/
public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (A == null || A.length() == 0 || k > A.length()) {
            return A;
        }
        StringBuilder sb = new StringBuilder();
        int resultLength = A.length() - k;
        int curLength = 0;
        int start = 0;
        int end = k;
        while (curLength < resultLength) {
            char minChar = A.charAt(start);
            int index = start;
            while (start <= end) {
                if (A.charAt(start) < minChar) {
                    minChar = A.charAt(start);
                    index = start;
                }
                start++;
            }
            if (sb.length() != 0 || minChar != '0') {
                sb.append(minChar);   
            }
            curLength++;
            start = index + 1;
            end = A.length() - (resultLength - curLength);
        }
        return sb.toString();
    }
}
