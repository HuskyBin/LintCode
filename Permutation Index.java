/*
Permutation Index Show result 

Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Have you met this question in a real interview? Yes
Example
Given [1,2,4], return 1.

Related Problems Expand 
*/
public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] smallerNumCount = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    count++;
                }
            }
            smallerNumCount[i] = count;
        }
        long sum = 1;
        long tempAccum = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            sum = sum + smallerNumCount[i] * tempAccum;
            if (i < A.length - 1) {
                tempAccum *= A.length - i;
            }
        }
        return sum;
    }
    
}


//Best Solution
// NO extra Space need 
public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long factor = 1;
        long sum = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    count++;
                }
            }
            sum += count * factor;
            factor *= (A.length - i);
        }
        
        return sum;
    }
}
