/*
Fair Subarray Sum Closest Show Result My Submissions

19% Accepted Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]

Challenge
O(nlogn) time


*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> resultList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resultList;
        }
        Element[] sums = new Element[nums.length + 1];
        int sum = 0;
        sums[0] = new Element(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i + 1] = new Element(sum, i);
        }
        
        Arrays.sort(sums);
        
        long minDiff = Long.MAX_VALUE;
        int start = -1;
        int end = -1;
        for (int i = 1; i < sums.length; i++) {
            if (Math.abs(sums[i].value - sums[i - 1].value) < minDiff) {
                minDiff = Math.abs(sums[i].value - sums[i - 1].value);
                start = Math.min(sums[i].index, sums[i - 1].index) + 1;
                end = Math.max(sums[i].index, sums[i - 1].index);
            }
        }
        resultList.add(start);
        resultList.add(end);
        return resultList;
    }
    
    private class Element implements Comparable<Element> {
        public int value;
        public int index;
        
        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        public int compareTo(Element e) {
            if (this.value < e.value) {
                return -1;
            }
            else if (this.value > e.value) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    
    
}

