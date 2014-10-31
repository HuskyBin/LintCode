/*
Fair Kth Largest Element Show Result My Submissions

19% Accepted
Find K-th largest element in an array.

Note
You can swap elements in the array

Example
In array [9,3,2,4,8], the 3th largest element is 4


*/
class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        if (numbers == null || numbers.size() == 0 || k <= 0 || k > numbers.size()) {
            return 0;
        }
        int start = 0;
        int end = numbers.size() - 1;
        int target = k;
        while (true) {
            int pIndex = new Random().nextInt(end - start + 1) + start;
            int partitionIndex = partition(numbers, start, end, numbers.get(pIndex));
            
            if (partitionIndex == target - 1) {
                int result = Integer.MIN_VALUE;
                for (int i = start; i <= partitionIndex; i++) {
                    result = Math.max(result, numbers.get(i));
                }
                return result;
            }
            else if (partitionIndex < target) {
                start = partitionIndex + 1;
            }
            else {
                end = partitionIndex - 1;
            }
        }
    }
    
    private int partition(ArrayList<Integer> numbers, int start, int end, int target) {
        int startIndex = start;
        int endIndex = end;
        while (startIndex <= endIndex) {
            while (startIndex <= endIndex && numbers.get(startIndex) <= target) {
                startIndex++;
            }
            while (startIndex <= endIndex && numbers.get(endIndex) > target) {
                endIndex--;
            }
            if (startIndex <= endIndex) {
                int s = numbers.get(startIndex);
                numbers.set(startIndex, numbers.get(endIndex));
                numbers.set(endIndex, s);
            }
        }
        return startIndex - 1;
    }
};
