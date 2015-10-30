/*
Medium Maximum Product Subarray Show result 

27% Accepted
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Have you met this question in a real interview? Yes
Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
*/
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null) {
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;
            max = Math.max(Math.max(max * nums[i], nums[i]), min * nums[i]);
            min = Math.min(Math.min(tempMax * nums[i], nums[i]), min * nums[i]);
            
            result = Math.max(max, result);
        }
        return result;
    }
}
