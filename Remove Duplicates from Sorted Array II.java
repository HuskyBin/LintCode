/*
Remove Duplicates from Sorted Array II Show Result My Submissions

25% Accepted
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].

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
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[last]) {
                if (count == 1) {
                    last++;
                    nums[last] = nums[i];
                    count++;
                }
            }
            else {
                last++;
                nums[last] = nums[i];
                count = 1;
            }
        }
        return last + 1;
    }
}
