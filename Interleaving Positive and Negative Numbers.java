/*
Fair Interleaving Positive and Negative Numbers Show Result My Submissions

16% Accepted Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
Note
You are not necessary to keep the original order or positive integers or negative integers.

Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other legal answer.

Challenge
Do it in-place and without extra memory.
*/
class Solution {
    /**
     * @param A: An integer array.
     * @return an integer array
     */
    public int[] rerange(int[] A) {
        // write your code here
        if (A == null) {
            return A;
        }
        int index = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                positiveCount++;
            }
            else {
                negativeCount++;
            }
        }
        
        boolean negativeFirst = true;
        if (positiveCount > negativeCount) {
            negativeFirst = false;
        }
        
        while (index < A.length) {
            firstIndex = findFirstIndex(A, firstIndex, !negativeFirst);
            if (firstIndex >= A.length) {
                break;
            }
            secondIndex = findFirstIndex(A, secondIndex, negativeFirst);
            if (secondIndex >= A.length) {
                break;
            }
            if (index % 2 == 0) {
                if ((negativeFirst == true && A[index] < 0) || (negativeFirst == false && A[index] >= 0)) {
                    firstIndex = index + 1;
                }
                else {
                    swap(A, index, firstIndex);
                    firstIndex++;
                }
            }
            else {
                if ((negativeFirst == false && A[index] < 0) || (negativeFirst == true && A[index] >= 0)) {
                    secondIndex = index + 1;
                }
                else {
                    swap(A, index, secondIndex);
                    secondIndex++;
                }
            }
            index++;
        }
        return A;
   }
   
   private int findFirstIndex(int[] A, int index, boolean isPositive) {
       while (index < A.length) {
           if (isPositive == true) {
               if (A[index] >= 0) {
                   return index;
               }
           }
           else {
               if (A[index] < 0) {
                   return index;
               }
           }
           index++;
       }
       return A.length;
   }
   
   private void swap(int[] A, int i, int j) {
       int temp = A[i];
       A[i] = A[j];
       A[j] = temp;
   }
}
