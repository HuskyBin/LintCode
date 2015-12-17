/*
First Missing Positive Show result 

Given an unsorted integer array, find the first missing positive integer.

Have you met this question in a real interview? Yes
Example
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Challenge
Your algorithm should run in O(n) time and uses constant space.
*/
public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here    
        if (A == null || A.length == 0) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] < A.length + 1 && A[A[i] - 1] != A[i] && A[i] != i + 1) {
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1; 
            }
        }
        return A.length + 1;
    }
}
