/*
Given a list of integers, which denote a permutation.

Find the next permutation in ascending order.

Note
The list may contains duplicate integers.

Example
For [1,3,2,3], the next permutation is [1,3,3,2]

For [4,3,2,1], the next permutation is [1,2,3,4]


*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's next permuation
     */
    public ArrayList<Integer> nextPermuation(ArrayList<Integer> nums) {
		// write your code
		ArrayList<Integer> resultList = new ArrayList<>();
		if (nums == null || nums.size() == 0) {
		    return resultList;
		}
		int index = nums.size() - 1;
		int decreaseIndex = -1;
		while (index > 0) {
		    if (nums.get(index - 1) < nums.get(index)) {
		        decreaseIndex = index - 1;
		        break;
		    }
		    index--;
		}
		if (decreaseIndex == -1) {
		    reverseList(resultList, nums, 0, nums.size() - 1);
		    return resultList;
		}
		int firstLargerIndex = findFirstLargerIndex(nums, 
		                                            nums.get(decreaseIndex), 
		                                            decreaseIndex + 1,
		                                            nums.size() - 1);
		swapElement(nums, firstLargerIndex, decreaseIndex);
		reverseList(resultList, nums, decreaseIndex + 1, nums.size() - 1);
		return resultList;
    }
    
    private void swapElement(ArrayList<Integer> nums, int indexOne, int indexTwo) {
        int temp = nums.get(indexOne);
        nums.set(indexOne, nums.get(indexTwo));
        nums.set(indexTwo, temp);
    }
    
    private int findFirstLargerIndex(ArrayList<Integer> nums,
                                     int target,
                                     int start,
                                     int end) {
        for (int i = end; i >= start; i--) {
            if (nums.get(i) > target) {
                return i;
            }
        }                
        return -1;
    }
    
    private void reverseList(ArrayList<Integer> resultList,
                             ArrayList<Integer> nums,
                             int start,
                             int end) {
        while (start < end) {
            swapElement(nums, start, end);
            start++;
            end--;
        }         
        for (int i = 0; i < nums.size(); i++) {
            resultList.add(nums.get(i));
        }
    }
}


