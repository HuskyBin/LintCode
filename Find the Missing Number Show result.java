
/*
Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.

Have you met this question in a real interview? Yes
Example
Given N = 3 and the array [0, 1, 3], return 2.

Challenge
Do it in-place with O(1) extra memory and O(n) time.

Tags Expand  

*/
//Method One, Sum
public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int result = (0 + nums.length) * (nums.length + 1) / 2 - sum;
        return result;
    }
}


// Method tow: XOR

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        if (nums == null) {
            return 0;
        }
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        for (int i = 0; i <= nums.length; i++) {
            result ^= i;
        }
        return result;
    }
}
