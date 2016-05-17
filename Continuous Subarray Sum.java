/*
Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

Have you met this question in a real interview? Yes
Example
Give [-3, 1, 3, -3, 4], return [1,4].
*/
public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }
        int sum = 0;
        int start = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) {
                sum = 0;
                start = i;
            }
            sum += A[i];
            if (sum >= maxSum) {
                maxSum = sum;
                maxStart = start;
                maxEnd = i;
            }
        }
        result.add(maxStart);
        result.add(maxEnd);
        return result;
    }
}
