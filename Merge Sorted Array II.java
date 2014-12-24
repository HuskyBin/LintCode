/*
Easy Merge Sorted Array II Show Result My Submissions

37% Accepted
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are mand n respectively.

Example
A = [1, 2, 3, empty, empty] B = [4,5]

After merge, A will be filled as [1,2,3,4,5]
*/
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        if (A == null || B == null || m < 0 || n < 0) {
            return;
        }
        int aEnd = m - 1;
        int bEnd = n - 1;
        while (aEnd >= 0 || bEnd >= 0) {
            int end = aEnd + bEnd + 1;
            if (aEnd >= 0 && bEnd >= 0 && A[aEnd] <= B[bEnd]) {
                A[end] = B[bEnd];
                bEnd--;
            }
            else if (aEnd >= 0 && bEnd >= 0) {
                A[end] = A[aEnd];
                aEnd--;
            }
            else {
                if (aEnd >= 0) {
                    return;
                }
                else {
                    A[end] = B[bEnd];
                    bEnd--;
                }
            }
        }
        return;
    }
}
