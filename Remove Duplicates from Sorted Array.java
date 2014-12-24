/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].

Example
Tags Expand 
*/
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[last]) {
                continue;
            }
            last++;
            nums[last] = nums[i];
        }
        return last + 1;
    }
}
