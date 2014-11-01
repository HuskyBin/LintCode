/*
Hard Maximum Subarray III Show Result My Submissions

13% Accepted
Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

Note
The subarray should contain at least one number


*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
        if (nums == null || nums.size() == 0 || k <= 0) {
            return Integer.MIN_VALUE;
        }
        int[][][] dp = new int[k + 1][nums.size()][nums.size()];
        return getMaxKSubArray(nums, k, 0, nums.size() - 1, dp);
    }
    
    private int getMaxKSubArray(List<Integer> nums, int k, int start, int end, int[][][] dp) {
        if (k == 1) {
            int subResult = getOneMaxSubArray(nums, start, end);
            return subResult;
        }
        if (dp[k][start][end] != 0) {
            return dp[k][start][end];
        }
        int subResult = Integer.MIN_VALUE;
        for (int i = start; i <= end + 1 - k; i++) {
            int max = getMaxKSubArray(nums, k - 1, i + 1, end, dp);
            int left = getOneMaxSubArray(nums, start, i);
            if (max + left > subResult) {
                subResult = max + left;
            }
        }
        dp[k][start][end] = subResult;
        return subResult;
    }
    
    private int getOneMaxSubArray(List<Integer> nums, int start, int end) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int number = nums.get(i);
            sum += number;
            if (sum > max) {
                max = sum;
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }
}
