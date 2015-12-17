/*
Permutation Index II Show result 

Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Have you met this question in a real interview? Yes
Example
Given the permutation [1, 4, 2, 2], return 3.

Related Problems Expand 
*/
public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        long sum = 1;
        long factor = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(A[i], 1);
            for (int j = i + 1; j < A.length; j++) {
                if (map.containsKey(A[j])) {
                    map.put(A[j], map.get(A[j]) + 1);
                }
                else {
                    map.put(A[j], 1);
                }
                if (A[j] < A[i]) {
                    count++;
                }
            }
            sum += factor * count / getDedup(map);
            factor *= A.length - i;
        }
        return sum;
    }
    
    private long getDedup(Map<Integer, Integer> map) {
        long mutiple = 1;
        for (Integer value : map.values()) {
            mutiple *= getFact(value);
        }
        return mutiple;
    }
    
    private long getFact(int value) {
        int fac = 1;
        for (int i = 2; i <= value; i++) {
            fac *= i;
        }
        return fac;
    }
}
