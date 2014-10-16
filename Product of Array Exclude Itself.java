/*
Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B without divide operation.

Example
For A=[1, 2, 3], B is [6, 3, 2]

Tags Expand 
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<>();
        if (A == null || A.size() == 0 || A.size() == 1) {
            return result;
        }
        
        long temp = 1;
        for (int i = 0; i < A.size(); i++) {
            result.add(temp);
            temp *= A.get(i);
        }
        
        temp = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            result.set(i, result.get(i) * temp);
            temp *= A.get(i);
        }
        
        return result;
    }
}
