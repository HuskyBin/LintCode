/*
Easy Median Show Result My Submissions

21% Accepted
Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.

Example
Given [4, 5, 1, 2, 3], return 3

Given [7, 9, 4, 5], return 5

Challenge
O(n) time.
*/
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int target = start + (end - start) / 2;
        while (true) {
            int pivotIndex = partition(nums, start, end);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            }
            else if (pivotIndex > target) {
                end = pivotIndex - 1;
            }
            else {
                start = pivotIndex + 1;
            }
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        Random random = new Random();
        int pivot = random.nextInt(end - start + 1) + start;
        swap(nums, pivot, end);
        int small = start - 1;
        for (int i = start; i <= end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, small, i);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
