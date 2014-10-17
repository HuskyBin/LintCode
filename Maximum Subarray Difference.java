/*
Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

Return the largest difference.

Note
The subarray should contain at least one number

Example
For [1, 2, -3, 1], return 6


*/
// Need to improve that we just need two array to store leftMax and leftMin,
// Then when we caculte the rightMin and RightMax, we could get the answer directly!
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() <= 1) {
            return 0;
        }
        int[] leftMax = new int[nums.size()];
        int[] leftMin = new int[nums.size()];
        int[] rightMax = new int[nums.size()];
        int[] rightMin = new int[nums.size()];
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int curMin = 0;
        int curMax = 0;
        for (int i = 0; i < nums.size(); i++) {
            curMin += nums.get(i);
            curMax += nums.get(i);
            min = Math.min(min, curMin);
            max = Math.max(max, curMax);
            if (curMin > 0) {
                curMin = 0;
            }
            if (curMax < 0) {
                curMax = 0;
            }
            leftMax[i] = max;
            leftMin[i] = min;
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        curMin = 0;
        curMax = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            curMin += nums.get(i);
            curMax += nums.get(i);
            min = Math.min(min, curMin);
            max = Math.max(max, curMax);
            if (curMin > 0) {
                curMin = 0;
            }
            if (curMax < 0) {
                curMax = 0;
            }
            rightMax[i] = max;
            rightMin[i] = min;
        } 
        
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            result = Math.max(result, Math.abs(leftMax[i] - rightMin[i + 1]));
            result = Math.max(result, Math.abs(leftMin[i] - rightMax[i + 1]));
        }
        return result;
    }
}


