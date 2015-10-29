/*
Medium Wood Cut Show result 

19% Accepted
Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

Have you met this question in a real interview? Yes
Example
For L=[232, 124, 456], k=7, return 114.
*/
public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || k <= 0) {
            return Integer.MIN_VALUE;
        }
        
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        
        int start = 1; int end = max;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        
        if (count(L, end) >= k) {
            return end;
        }
        if (count(L, start) >= k) {
            return start;
        }
        return 0;
    }
    
    private int count(int[] L, int len) {
        int num = 0;
        for (int i = 0; i < L.length; i++) {
            num += L[i] / len;
        }
        return num;
    }
}
