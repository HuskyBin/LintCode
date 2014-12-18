/*
Fair Jump Game II Show Result My Submissions

27% Accepted
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Tags Expand 
*/
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null) {
            return 0;
        }
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        int startIndex = 0;
        int result = 1;
        while (startIndex < A.length) {
            if (A[startIndex] + startIndex >= A.length - 1) {
                return result;
            }
            if (A[startIndex] == 0) {
                return -1;
            }
            int maxValue = A[startIndex] + startIndex;
            int maxIndex = startIndex;
            for (int i = startIndex + 1; i <= A[startIndex] + startIndex; i++) {
                if (maxValue < A[i] + i) {
                    maxValue = A[i] + i;
                    maxIndex = i;
                }
            }
            result++;
            startIndex = maxIndex;
        }
        return result;
    }
}


// DP
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null) {
            return 0;
        }
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        int[] minJump = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            minJump[i] = -1;
        }
        minJump[0] = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (minJump[j] >= 0 && (A[j] + j >= i)) {
                    if (minJump[i] == -1) {
                        minJump[i] = minJump[j] + 1;
                    }
                    else {
                        minJump[i] = Math.min(minJump[i], minJump[j] + 1);
                    }
                }
            }
        }
        return minJump[A.length - 1];
    }
}
