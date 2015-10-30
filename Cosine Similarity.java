/*
Cosine similarity is a measure of similarity between two vectors of an inner product space that measures the cosine of the angle between them. The cosine of 0° is 1, and it is less than 1 for any other angle.

See wiki: Cosine Similarity

Here is the formula:

/media/problem/cosine-similarity.png

Given two vectors A and B with the same size, calculate the cosine similarity.

Return 2.0000 if cosine similarity is invalid (for example A = [0] and B = [0]).

Have you met this question in a real interview? Yes
Example
Given A = [1, 2, 3], B = [2, 3 ,4].

Return 0.9926.

Given A = [0], B = [0].

Return 2.0000
*/
class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null || A.length != B.length) {
            return 2.00;
        }
        Long aSum = 0L;
        Long bSum = 0L;
        Long aBProductSum = 0L;
        
        for (int i = 0; i < A.length; i++) {
            aSum += A[i] * A[i];
            bSum += B[i] * B[i];
            aBProductSum += A[i] * B[i];
        }
        
        if (aSum == 0 || bSum== 0) {
            return 2.00;
        }
        
        return aBProductSum / (Math.sqrt(aSum) * Math.sqrt(bSum));
    }
}
