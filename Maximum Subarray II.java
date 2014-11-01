/*
Given an array of integers, find two non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

Note
The subarray should contain at least one number

Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, -2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.
*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            int left = getMaxSubArray(nums, 0, i);
            int right = getMaxSubArray(nums, i + 1, nums.size() - 1);
            if (left + right > max) {
                max = left + right;
            }
        }
        return max;
    }
    
    private int getMaxSubArray(List<Integer> nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int num = nums.get(i);
            sum += num;
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


