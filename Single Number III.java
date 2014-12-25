/*
Easy Single Number III Show Result My Submissions

30% Accepted
Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge
O(n) time, O(1) extra space.
*/
public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> resultList = new ArrayList<>();
        if (A == null || A.length == 0) {
            return resultList;
        }
        int number = A[0];
        for (int i = 1; i < A.length; i++) {
            number ^= A[i];
        }
        int index = findDigitOneIndex(number);
        int numberOne = 0;
        int numberTwo = 0;
        for (int i = 0; i < A.length; i++) {
            if (isDigitOne(A[i], index)) {
                numberOne ^= A[i];
            }
            else {
                numberTwo ^= A[i];
            }
        }
        resultList.add(numberOne);
        resultList.add(numberTwo);
        return resultList;
    }
    
    private int findDigitOneIndex(int num) {
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean isDigitOne(int num, int index) {
        if ((num & (1 << index)) != 0) {
            return true;
        }
        return false;
    }
}
