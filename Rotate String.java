/*
Given a string and an offset, rotate string by offset. (rotate from left to right)

Example
Given "abcdefg" and offset=3, return "efgabcd"
*/
public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char [] rotateString(char [] A, int offset) {
        // wirte your code here
        if (A == null || A.length == 0 || offset <= 0) {
            return A;
        }
        offset %= A.length;
        int start = 0;
        int end = (A.length - offset) - 1;
        swapRange(A, start, end);
        start = (A.length - offset);
        end = A.length - 1;
        swapRange(A, start, end);
        start = 0;
        end = A.length - 1;
        swapRange(A, start, end);
        return A;
    }
    
    private void swapRange(char[] A, int start, int end) {
        while (start <= end) {
            char temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
};
