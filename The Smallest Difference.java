/*
Given two array of integers(the first array is array A, the second array is array B), now we are going to find a element in array A which is A[i], and another element in array B which is B[j], so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.

Have you met this question in a real interview? Yes
Example
For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
*/
public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null  || A.length == 0 || B.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int aIndex = 0;
        int bIndex = 0;
        int result = Math.abs(A[0] - B[0]);
        while (aIndex < A.length && bIndex < B.length) {
            result = Math.min(result, Math.abs(A[aIndex] - B[bIndex]));
            if (result == 0) {
                break;
            }
            if (A[aIndex] < B[bIndex]) {
                aIndex++;
            }
            else {
                bIndex++;
            }
        }
        return result;
    }
}
