/*
Hard Median II Show Result My Submissions

26% Accepted
Numbers keep coming, return the median of numbers at every time a new number added.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3]

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3]

For numbers coming list: [2, 20, 100], return [2, 2, 20]

Challenge
O(nlogn) time

Clarification
What's the definition of Median?

Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n-1)/2].
For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
*/
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }
        List<Integer> resultList = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(20, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            addNumberIntoHeap(nums[i], maxHeap, minHeap, resultList);
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
    
    private void addNumberIntoHeap(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, List<Integer> resultList) {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.size() == 0) {
                minHeap.offer(num);
            }
            else {
                if (num > maxHeap.peek()) {
                    minHeap.offer(num);
                }
                else {
                    maxHeap.offer(num);
                    int topNum = maxHeap.poll();
                    minHeap.offer(topNum);
                }
            }
        }
        else {
            if (maxHeap.size() == 0) {
                if (num < minHeap.peek()) {
                    maxHeap.offer(num);
                }
                else {
                    minHeap.offer(num);
                    int topNum = minHeap.poll();
                    maxHeap.offer(topNum);
                }
            }
            else {
                if (num > maxHeap.peek()) {
                    minHeap.offer(num);
                    int topNum = minHeap.poll();
                    maxHeap.offer(topNum);
                }
                else {
                    maxHeap.offer(num);
                }
            }
        }
        addMedianToList(maxHeap, minHeap, resultList);
    }
    
    private void addMedianToList(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, List<Integer> resultList) {
        if (minHeap.size() == maxHeap.size()) {
            resultList.add(maxHeap.peek());
        }
        else {
            resultList.add(minHeap.peek());
        }
    }
}
