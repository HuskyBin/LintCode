/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. 

Note
You may assume that each input would have exactly one solution.

Example
For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        if (numbers == null || numbers.length <= 2) {
            return Integer.MAX_VALUE;
        }
        int[] result = new int[1];
        Arrays.sort(numbers);
        result[0] = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int firstNum = numbers[i];
            findTwoSum(numbers, target - firstNum, firstNum, i + 1, result);
            if (result[0] == target) {
                break;
            }
        }
        return result[0];
    }
    
    private void findTwoSum(int[] numbers, 
                            int target, 
                            int firstNum, 
                            int index,
                            int[] result) {
        int start = index;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                result[0] = target + firstNum;
                return;
            }
            else {
                result[0] = (Math.abs(result[0] - (target + firstNum)) > 
                            (Math.abs(numbers[start] + numbers[end] - target))) ? 
                            numbers[start] + numbers[end] + firstNum : result[0]; 
                if (numbers[start] + numbers[end] > target) {
                    end--;
                }
                else {
                    start++;
                }
            }
        }
    }
}

