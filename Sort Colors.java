/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note
You are not suppose to use the library's sort function for this problem. 

Example
Clarification
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/
class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroIndex = -1;
        int twoIndex = nums.length;
        int index = 0;
        while (index < twoIndex) {
            if (nums[index] == 0) {
                zeroIndex++;
                swap(nums, zeroIndex, index);
                index++;
            }
            else if (nums[index] == 2) {
                twoIndex--;
                swap(nums, index, twoIndex);
            }
            else {
                index++;
            }
        }
    }
    
    private void swap(int[] nums, int aIndex, int bIndex) {
        int temp = nums[aIndex];
        nums[aIndex] = nums[bIndex];
        nums[bIndex] = temp;
    }
}
