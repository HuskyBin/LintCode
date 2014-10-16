/*
Given an array "nums" of integers and an int "k", Partition the array (i.e move the elements in "nums") such that,

    * All elements < k are moved to the left

    * All elements >= k are moved to the right

Return the partitioning Index, i.e the first index "i" nums[i] >= k.

Note
You should do really partition in array "nums" instead of just counting the numbers of integers smaller than k.

If all elements in "nums" are larger than k, then return "nums.length"

Example
If nums=[3,2,2,1] and k=2, a valid answer is 1.
*/
public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    //write your code here
	    if (nums == null || nums.size() == 0) {
	        return 0;
	    }
	    int start = 0;
	    int end = nums.size() - 1;
	    while (start <= end) {
	        while (start <= end && nums.get(start) < k) {
	            start++;
	        }
	        while (start <= end && nums.get(end) >= k) {
	            end--;
	        }
	        if (start > end) {
	            break;
	        }
	        int temp = nums.get(start);
	        nums.set(start, nums.get(end));
	        nums.set(end, temp);
	        start++;
	        end--;
	    }
	    return start;
    }
}
