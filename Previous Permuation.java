/*
Fair Previous Permuation Show Result My Submissions

27% Accepted
Given a list of integers, which denote a permutation.

Find the previous permutation in ascending order.

Note
The list may contains duplicate integers.

Example
For [1,3,2,3], the previous permutation is [1,2,3,3]

For [1,2,3,4], the previous permutation is [4,3,2,1]
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		ArrayList<Integer> resultList = new ArrayList<>();
		if (nums == null || nums.size() == 0) {
		    return resultList;
		}
		int index = nums.size() - 1;
		int increaseIndex = -1;
		while (index > 0) {
		    if (nums.get(index) < nums.get(index - 1)) {
		        increaseIndex = index - 1;
		        break;
		    }
		    index--;
		}
		if (increaseIndex == -1) {
		    reverseList(resultList, nums, 0, nums.size() - 1);
		    return resultList;
		}
		int firstSmallIndex = findFirstSmallIndex(nums, 
		                                          nums.get(increaseIndex),
		                                          increaseIndex + 1,
		                                          nums.size() - 1);
		swapElement(nums, increaseIndex, firstSmallIndex);
		reverseList(resultList, nums, increaseIndex + 1, nums.size() - 1);
		return resultList;
    }
    
    private void swapElement(ArrayList<Integer> nums, int indexOne, int indexTwo) {
        int temp = nums.get(indexOne);
        nums.set(indexOne, nums.get(indexTwo));
        nums.set(indexTwo, temp);
    }
    
    private int findFirstSmallIndex(ArrayList<Integer> nums,
                                    int target,
                                    int start,
                                    int end) {
        for (int i = end; i >= start; i--) {
            if (nums.get(i) < target) {
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
