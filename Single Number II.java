/*
Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

Example
Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge
One-pass, constant exstra space
*/
public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] digits = new int[32];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 32; j++) {
                if (digitAtJIsOne(A[i], j)) {
                    digits[j]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (digits[i] % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
    
    private boolean digitAtJIsOne(int num, int index) {
        if ((num & (1 << index)) == 0) {
            return false;
        }
        return true;
    }
}
